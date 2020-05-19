/* https://github.com/orange1438 */
package com.march.domain;

import java.io.Serializable;

/** 
 * @author orange1438
 * date:2020/05/19 01:06
 */
public class User implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 1489557487072839314L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private String name;

    /** 
     */ 
    private Integer age;

    /** 
     * 获取 test_user.id
     * @return test_user.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 test_user.id
     * @param id test_user.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 test_user.name
     * @return test_user.name
     */
    public final String getName() {
        return name;
    }

    /** 
     * 设置 test_user.name
     * @param name test_user.name
     */
    public final void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /** 
     * 获取 test_user.age
     * @return test_user.age
     */
    public final Integer getAge() {
        return age;
    }

    /** 
     * 设置 test_user.age
     * @param age test_user.age
     */
    public final void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append("]");
        return sb.toString();
    }
}