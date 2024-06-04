package com.dashboard.custom.DTO;


import java.sql.Date;

public class MembersDTO {

    public enum MembersEnum {
        ADMIN, USER, VISITOR
    }

    private int memberSeq; // 템플릿 및 설정을 가져오기 위한 회원번호
    private String memberEmail; // ID 겸 이후 구현해볼 email 레터 기능에 사용
    private String memberPw; // password로 원형이 아닌 암호화 된 내용을 저장
    private String memberName; // 메인화면에 띄울 회원이름 및 닉네임
    private MembersEnum memberGrade; // 화면 표시를 위한 회원 등급
    private Date memberDate; // 회원관리의 용이성을 위한 회원 가입 날짜

    public MembersDTO(int memberSeq, String memberEmail, String memberPw, String memberName, MembersEnum memberGrade, Date memberDate) {
        this.memberSeq = memberSeq;
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberGrade = memberGrade;
        this.memberDate = memberDate;
    }

    public int getMemberSeq() {
        return memberSeq;
    }

    public void setMemberSeq(int memberSeq) {
        this.memberSeq = memberSeq;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public MembersEnum getMemberGrade() {
        return memberGrade;
    }

    public void setMemberGrade(MembersEnum memberGrade) {
        this.memberGrade = memberGrade;
    }

    public Date getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(Date memberDate) {
        this.memberDate = memberDate;
    }
}
