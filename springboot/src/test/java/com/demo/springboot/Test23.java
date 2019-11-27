package com.demo.springboot;

import lombok.Data;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test23
 * @date : Create in 2019/10/5 10:28
 */
public class Test23 {
    public static void main(String[] args) {
        String str = "SELECT\n" +
                "	B.ACC_NUM as accNbr,\n" +
                "	D.NAME as name,\n" +
                "	C.ACCT_NAME as acctName,\n" +
                "	B.OWNER_CUST_ID as ownerCustId,\n" +
                "	C.CUST_ID as custId,\n" +
                "	to_char(C.STATUS_DATE,'yyyy-mm-dd') as statusDate,\n" +
                "	F.TAX_ID as taxId,\n" +
                "	to_char(F.EFF_DATE,'yyyy-mm-dd') as effDate,\n" +
                "	to_char(F.EXP_DATE,'yyyy-mm-dd') as expDate,\n" +
                "   CASE WHEN B.OWNER_CUST_ID = C.CUST_ID THEN '一致' ELSE '不一致' END as isSame \n" +
                "FROM\n" +
                "	RATE_USR_PROFILEDB.PROD_INST_ACCT_REL A\n" +
                "	LEFT JOIN RATE_USR_PROFILEDB.PROD_INST B ON A.PROD_INST_ID = B.PROD_INST_ID\n" +
                "	LEFT JOIN RATE_USR_PROFILEDB.ACCOUNT C ON A.ACCT_ID = C.ACCT_ID\n" +
                "	LEFT JOIN ACCTDB.A_SYS_DOMAIN D ON B.STATUS_CD = D.DOMAIN AND D.TABLE_NAME = 'PROD_INST' AND D.FIELD_NAME = 'STATUS_CD'\n" +
                "	LEFT JOIN RATE_USR_PROFILEDB.CUSTOMER E ON C.CUST_ID = E.CUST_ID\n" +
                "	LEFT JOIN RATE_USR_PROFILEDB.TAX_PAYER F ON E.TAX_PAYER_ID = F.TAX_PAYER_ID\n" +
                "where A.ACCT_ID = #{acctId}";
        System.out.println(str);
    }
}
