package com.qfedu.pojo;

public class SysRight {
    private Integer rightCode;

    private Integer rightParentCode;

    private String rightName;

    private String rightUrl;

    private Integer rightNodeType;

    private Integer rightFlag;

    public Integer getRightCode() {
        return rightCode;
    }

    public void setRightCode(Integer rightCode) {
        this.rightCode = rightCode;
    }

    public Integer getRightParentCode() {
        return rightParentCode;
    }

    public void setRightParentCode(Integer rightParentCode) {
        this.rightParentCode = rightParentCode;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    public String getRightUrl() {
        return rightUrl;
    }

    public void setRightUrl(String rightUrl) {
        this.rightUrl = rightUrl == null ? null : rightUrl.trim();
    }

    public Integer getRightNodeType() {
        return rightNodeType;
    }

    public void setRightNodeType(Integer rightNodeType) {
        this.rightNodeType = rightNodeType;
    }

    public Integer getRightFlag() {
        return rightFlag;
    }

    public void setRightFlag(Integer rightFlag) {
        this.rightFlag = rightFlag;
    }
}