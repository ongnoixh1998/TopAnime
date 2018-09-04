package com.animetop.web.core.data.daoimpl;

import com.animetop.web.core.common.utils.HibernateUtil;
import com.animetop.web.core.data.dao.AbstractDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class AbstractDaoImpl<ID extends Serializable,T>  implements AbstractDao<ID,T> {
    private Class<T> presistenceClass;
    public AbstractDaoImpl(){
      /**
       * get name class entity
       * */
        presistenceClass = (Class<T>) ((ParameterizedType)(getClass().getGenericSuperclass())).getActualTypeArguments()[1];
    }
    public String getNamePresistenceClass(){
        return this.presistenceClass.getSimpleName();
    }
    /**
     * select all table
     * */
    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction =null;
        try{
            transaction = session.beginTransaction();
            StringBuilder sql = new StringBuilder("SELECT * FROM");
            sql.append(this.getNamePresistenceClass());
            Query query = session.createQuery(sql.toString());
            list = query.list();
        }catch (HibernateException e){
            transaction.rollback();

        }finally {
            session.close();
        }
        return list;
    }


}
