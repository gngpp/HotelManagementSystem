package mvcpro.model.dao;

import com.lqing.orm.internal.SimpleDaoImpl;
import mvcpro.model.entity.Client;

public class ClientDao extends SimpleDaoImpl<Client> {
    public static void main(String[] args) throws Exception {
        ClientDao clientDao=new ClientDao();
        System.out.println(clientDao.list());
    }
}
