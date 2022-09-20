package cqut.cn.edu.pojo;

import java.util.List;

//分页查询类
public class Paging<T>{
    //总条数
    private int totalcount;

    //list集合
    private List<T> rows;

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
