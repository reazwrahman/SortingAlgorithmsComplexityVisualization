#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Feb  6 12:53:03 2021

@author: Reaz
"""


import os,re,sys  
import numpy as np 
import matplotlib.pyplot as plt 

import random



class TwoDGrapher(object): 
    
    def __init__(self): 
        
       pass
              
    def writer (self,filename,content):  
    
        file=open(filename,'w') 
        file.write(content) 
        file.close()

    def reader(self,filename): 
        
        file=open(filename,"r") 
        content=file.read() 
        return content   
    
    def read_by_line(self,filename): 
        
        file=open(filename,"r") 
        content=file.readlines() 
        return content  
    
    def appender (self,filename,content):  
        
        file=open(filename,'a') 
        file.write(content) 
        file.close()  
        
    
        
    def one_column_plot(self,x,y,label=["X vs Y graph"],color="red",xlabel="X",ylabel="Y",save_as=None): 
        
        fig=plt.figure() 
        ax1=fig.add_subplot(111) 
        ax1.set_xlabel(xlabel) 
        ax1.set_ylabel(ylabel) 
        ax1.plot(x,y,color=color,label=label[0]) 
        leg=ax1.legend() 
        plt.show()   
        
        if save_as!=None: 
            fig.savefig(save_as,dpi=200)
        

    
    def two_column_plot(self,x,y1,y2,label=['Y1','Y2'],xlabel="X",ylabel="Y",colors=["green","blue"],save_as=None): 
        
        fig=plt.figure() 
        ax1=fig.add_subplot(111) 
        ax1.plot(x,y1,color=colors[0],label=label[0],marker="o")  
        ax1.set_xlabel(xlabel) 
        ax1.set_ylabel(ylabel) 
        
        ax1.plot(x,y2,color=colors[1],marker="o",label=label[1]) 
        leg=ax1.legend()
        plt.show()   
        
        if save_as!=None: 
            fig.savefig(save_as,dpi=200)
        
    def three_column_plot(self,x,y1,y2,y3,label=['Y1','Y2','Y3'],colors=["red","green","blue"],xlabel="X",ylabel="Y",save_as=None): 
        
        fig=plt.figure() 
        ax1=fig.add_subplot(111) 
        ax1.plot(x,y1,color=colors[0],label=label[0],marker="o")  
        ax1.set_xlabel(xlabel) 
        ax1.set_ylabel(ylabel) 
         
        plt.xticks(np.arange(min(x), max(x)+1, int( (max(x)-min(x)) /10) ))

        ax1.plot(x,y2,color=colors[1],marker="o",label=label[1]) 
        ax1.plot(x,y3,color=colors[2],marker="o",label=label[2])
        
        leg=ax1.legend()  
        plt.show()  
        
        if save_as!=None: 
            fig.savefig(save_as,dpi=200)
        
    ## INPUTS:
    # pass in one x array and an array of all the y arrays, a list of lists 
    # pass in a list of strings for all the y labels 
    # pass in a list of all y column colors (optional)
    def multi_column_plot(self,x,lists_of_y,colors=None,label=None,xlabel="X",save_as=None): 

        ## assign colors for the plot         
        assigned_colors=[]
        if colors==None: 
            assigned_colors=self.random_colors_assignment(len(lists_of_y)) 
        else: 
            assigned_colors=colors
        
        ## assign label/legends  
        labels=[]
        if label==None:  
            for i in range (len(lists_of_y)):
                labels.append(f'Y{i+1}')
        
        
        ### scale x and y properly 
        all_y=[] 
        for i in range(len(lists_of_y)): 
            for j in range (len(lists_of_y[i])):
                all_y.append(lists_of_y[i][j]) 
        
        fig,ax1=plt.subplots()   
        xmin,xmax=plt.xlim() 
        ymin, ymax = plt.ylim()
        plt.xlim(min(x),max(x))
        plt.ylim(min(all_y), max(all_y)) 
        
        
        ## set up all the ax's and curves
        ax=[]   
        curves=[]
        
        ## we already have ax1 and curve1 defined, define the others
        for i in range (len(lists_of_y)-1): 
            ax.append(f'ax{i+2}')  
            curves.append(f'curve{i+2}')
        
        for i in range (len(ax)): 
            ax[i]=ax1.twinx() 
            ax[i].tick_params(axis='y',left=False, right=False,labelleft=False, labelright=False)
        
        curve1=ax1.plot(x,lists_of_y[0],color=assigned_colors[0],label=labels[0],marker="o")
        for i in range (len(curves)): 
            curves[i]=ax[i].plot(x,lists_of_y[i+1],assigned_colors[i+1],marker="o",label=labels[i+1]) 
        
       
        plt.plot() 
        plt.show() 
        
        if save_as!=None: 
            fig.savefig(save_as,dpi=200)
    
    
    def random_colors_assignment(self,list_size): 
        
        avail_colors=["red","blue","green","orange","purple","brown","pink","gray","olive","cyan"]
        colors=[] 
        
        if list_size<=9: 
            for i in range (list_size): 
                colors.append(avail_colors[i]) 
        else: 
            for i in range (len(avail_colors)):  
                colors.append(avail_colors[i]) 
            
            for i in range (list_size-(len(avail_colors))): 
                colors.append(avail_colors[int((random.random()*10)-1)]) 
        
        
        return colors
                    
def test():
    x=[100,200,300]  
    y1=[40,5,61] 
    y2=[70,81,19] 
    y3=[110,11,21]   
    y4=[99,88,77] 
    y5=[55,51,61] 
    y6=[86,89,222] 
    y7=[120,1,3]
    y=[y1,y2,y4,y5,y6,y7] 
    
    
    a=TwoDGrapher() 
    a.three_column_plot(x,y1,y2,y3) 
    #a.multi_column_plot(x,y) 
    
if __name__=="__main__": 
    test()

