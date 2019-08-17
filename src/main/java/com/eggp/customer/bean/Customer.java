package com.eggp.customer.bean;

/**
 * 客户
 */
public class Customer {
    // id
    private long id;
    // 客户名称
    private String name;
    // 联系人
    private String contact;
    // 电话号码
    private String telephone;
    // 邮箱地址
    private String email;
    // 备注
    private String remark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Customer() {
    }

    public Customer(long id, String name, String contact, String telephone, String email, String remark) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.telephone = telephone;
        this.email = email;
        this.remark = remark;
    }


    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("contact", contact)
                .append("telephone", telephone)
                .append("email", email)
                .append("remark", remark)
                .toString();
    }
}
