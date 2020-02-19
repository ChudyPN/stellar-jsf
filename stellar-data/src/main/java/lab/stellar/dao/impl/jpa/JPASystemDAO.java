package lab.stellar.dao.impl.jpa;

import lab.stellar.dao.SystemDAO;
import lab.stellar.entities.Planet;
import lab.stellar.entities.PlanetarySystem;

import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Alternative
public class JPASystemDAO implements SystemDAO {

    Logger logger = Logger.getLogger(JPASystemDAO.class.getName());
    //@PersistenceContext(name = "stellar-unit")
    EntityManager em;

    @Override
    public List<PlanetarySystem> getAllPlanetarySystems() {
        logger.info("querying for all planetary systems");
        return em.createQuery("select s from PlanetarySystem s").getResultList();
    }

    @Override
    public List<PlanetarySystem> getPlanetarySystemsByName(String like) {
        logger.info("querying for planetary systems like " + like);

        return em.
                createQuery("select s from PlanetarySystem s where s.name like :like").
                setParameter("like", like).
                getResultList();
    }

    @Override
    public PlanetarySystem getPlanetarySystem(int id) {
        logger.info("querying for planetary system " + id);

        return em.find(PlanetarySystem.class, id);
    }

    @Override
    public PlanetarySystem addPlanetarySystem(PlanetarySystem system) {
        logger.info("adding new planetary system " + system);

        em.persist(system);
         return system;
    }
}
