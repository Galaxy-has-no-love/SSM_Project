package com.byh.biyesheji.util;

import lombok.ToString;

/**
 * 分页工具类  utils包下面放的项目文件的工具类
 */
@ToString
public class Page {

    /**
     * 开始页数
     */
    private int start;
    /**
     * 每页显示页数
     */
    private int count;
    /**
     * 总个数
     */
    private int total;

    /**
     * 默认每页显示5条
     */
    private static final int DEFAULT_COUNT = 8;


    public Page (){
        count = DEFAULT_COUNT;
    }
    public Page(int start, int count) {
        this();
        this.start = start;
        this.count = count;
    }

    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public boolean isHasPreviouse(){
        if(start==0) {
            return false;
        }
        return true;
    }
    public boolean isHasNext(){
        if(start==getLast()) {
            return false;
        }
        return true;
    }

    public int getTotalPage(){
        int totalPage;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (0 == total % count) {
            totalPage = total /count;
        }
            // 假设总数是51，不能够被5整除的，那么就有11页
        else {
            totalPage = total / count + 1;
        }

        if(0==totalPage) {
            totalPage = 1;
        }
        return totalPage;

    }

    public int getLast(){
        int last;
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if (0 == total % count) {
            last = total - count;
        }
            // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        else {
            last = total - total % count;
        }
        last = last<0?0:last;
        return last;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

}
