#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Feb  6 12:54:56 2021

@author: Reaz
"""

import os,re,sys  
from TwoDGrapher import TwoDGrapher 

import matplotlib.pyplot as plt 

def generate_sizeVtime_lists(filename): 
    
    grapher=TwoDGrapher()
    lines=grapher.read_by_line(filename) 
    
    size=[] 
    time=[]
    for i in range (1,len(lines)):  
        temp=lines[i].strip('\n').split(',') 
        size.append(int(temp[0])) 
        time.append(int(temp[1])/10e6)  # time in millisec
    
    return size, time 


def main():


    file0="insertionsort_timing_logger.txt"
    file1='mergesort_timing_logger.txt' 
    file2="quicksort_timing_logger.txt" 
    
    size1,time_ms1=generate_sizeVtime_lists(file0) 
    size2,time_ms2=generate_sizeVtime_lists(file1)
    size3,time_ms3=generate_sizeVtime_lists(file2)
     
    
    grapher=TwoDGrapher() 
    grapher.one_column_plot(size1,time_ms1,label=["InsertionSort"],color="red",xlabel="Array Size",ylabel="Time (millisec)",save_as="InsertionSort_Complexity_Graph.png")
    grapher.one_column_plot(size2,time_ms2,label=["MergeSort"],color="green",xlabel="Array Size",ylabel="Time (millisec)",save_as="MergeSort_Complexity_Graph.png")
    grapher.one_column_plot(size3,time_ms3,label=["QuickSort"],color="blue",xlabel="Array Size",ylabel="Time (millisec)",save_as="QuickSort_Complexity_Graph.png") 
    
    all_time=[time_ms1,time_ms2,time_ms3] 
    grapher.three_column_plot(size1,time_ms1,time_ms2,time_ms3,
                              label=["InsertionSort","MergeSort","QuickSort"],
                              colors=["red","green","blue"],xlabel="Array Size",ylabel="Time (millisec)", 
                              save_as="Complexity_Comparison_Graph.png")  
    
    grapher.two_column_plot(size1,time_ms2,time_ms3,
                              label=["MergeSort","QuickSort"],
                              colors=["green","blue"],xlabel="Array Size",ylabel="Time (millisec)", 
                              save_as="mergeVSquick_Graph.png")
    #grapher.multi_column_plot(size1,all_time)

if __name__=="__main__": 
    main()