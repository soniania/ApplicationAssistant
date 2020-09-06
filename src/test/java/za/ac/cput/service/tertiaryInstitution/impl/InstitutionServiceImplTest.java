package za.ac.cput.service.tertiaryInstitution.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import za.ac.cput.entity.tertiaryInstitution.Institution;
import za.ac.cput.factory.tertiaryInstitution.InstitutionFactory;
import za.ac.cput.service.tertiaryInstitution.InstitutionService;


import java.util.Set;




@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InstitutionServiceImplTest {

    private static InstitutionService service = InstitutionServiceImpl.getService();
    private static Institution institution = InstitutionFactory.createInstitution("CPUT", "2929");

    @Test
    public void d_getAll() {
        Set<Institution> institutions = service.getAll();
        Assert.assertEquals(1, institutions.size());
        System.out.println("All Institutions: " + institutions);

    }

    @Test
    public void e_getAllStartingWith() {
        Set<Institution> institutions = service.getAllStartingWith("c");
        Assert.assertEquals(1, institutions.size());
        System.out.println("Get All Starting With 'C': " + institutions);
    }

    @Test
    public void a_create() {
        Institution created = service.create(institution);
        Assert.assertEquals(institution.getInstitutionId(), created.getInstitutionId());
        System.out.println("Created: " +created);
    }

    @Test
    public void b_read() {
        Institution read = service.read(institution.getInstitutionId());
        System.out.println("Read: " +read);
    }

    @Test
    public void c_update() {
        Institution updated = new Institution.Builder().copy(institution).setInstitutionId("2929").build();
        updated = service.update(updated);
        System.out.println("Updated: " +updated);
    }

    @Test

    public void f_delete() {
        boolean deleted = service.delete(institution.getInstitutionId());
        Assert.assertTrue(deleted);
    }
}