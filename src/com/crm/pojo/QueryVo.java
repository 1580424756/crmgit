package com.crm.pojo;

/**
 *  前台发起请求,需要接收请求过来的查询条件数据，可以使用pojo接收数据。需要依此编写查询逻辑。
 */
public class QueryVo {
    //客户名称
    private String custName;
    //客户来源
    private String custSource;
    //所属行业
    private String custIndustry;
    //客户级别
    private String custLevel;

    //当前页号
    private Integer page;
    //每页数量
    private Integer size =10;

    //查询的启始位置，从0开始查多少条数据

    private Integer startRow = 0;

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }
}
   /*#{}里的内容要入pojo类的属性名一致，而pojo类的属性名与页面的name名一致，而为什么页面name这里可以这么写，时因为查到是base_dict表，
              而这个pojo类收到的是模糊查询前台手写的名字，与customer表无关，这个pojo类接收的是前台的数据
            */
/*启始点，多少条数据------从startrow位置开始开始size条数据*/