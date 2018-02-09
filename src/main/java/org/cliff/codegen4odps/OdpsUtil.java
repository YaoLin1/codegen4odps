package org.cliff.codegen4odps;

import com.aliyun.odps.Odps;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;

/**
 * Created by zhujl on 2018/1/26.
 */
public class OdpsUtil {

    private static Odps odps;
    public synchronized  static Odps getInstance(String accessId,String accessKey,String odpsUrl,String project ) {
        if(odps == null) {
            Account account = new AliyunAccount(accessId,accessKey);
            odps = new Odps(account);
            odps.setEndpoint(odpsUrl);
            odps.setDefaultProject(project);
        }
        return odps;

    }


}
