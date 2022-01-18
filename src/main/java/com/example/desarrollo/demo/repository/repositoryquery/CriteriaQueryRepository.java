package com.example.desarrollo.demo.repository.repositoryquery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.desarrollo.demo.hospital.Consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CriteriaQueryRepository implements ConsultaRepositoryCustom { 
        
    @Autowired
    EntityManager em;

    @Override
    public List<Consulta> findConsultasByEstadoAndTipocons(Boolean estado, String tipocons) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Consulta> cq = cb.createQuery(Consulta.class);
        Root<Consulta> consulta = cq.from(Consulta.class);

        Predicate predicates = null;
        
        if (estado != null) {
            predicates = cb.equal(consulta.get("tipocons"), tipocons);
        }
        if (tipocons != null) {
            predicates = cb.isTrue(consulta.get("estado"));
        }
        
        predicates.add(cb.greaterThanOrEqualTo(consulta.get("fechacons"), new Date()));
        
        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }

    
}
