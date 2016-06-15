package net.smartcosmos.dao.things;

import net.smartcosmos.dto.things.ThingCreate;
import net.smartcosmos.dto.things.ThingResponse;
import net.smartcosmos.dto.things.ThingUpdate;

import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ThingDao {

    /**
     * Creates a thing in the realm of a given tenant.
     *
     * @param tenantId the tenant ID
     * @param thingCreate the thing to create
     * @return an {@link ThingResponse} instance for the created thing
     * @throws ConstraintViolationException if the {@link ThingCreate} violates constraints enforced by the persistence service
     */
    ThingResponse create(String tenantId, ThingCreate thingCreate) throws ConstraintViolationException;

    /**
     * Updates a thing in the realm of a given tenant.
     *
     * @param tenantId the tenant ID
     * @param thingUpdate the thing to update
     * @return an {@link ThingResponse} instance for the updated thing
     * @throws ConstraintViolationException if the {@link ThingUpdate} violates constraints enforced by the persistence service
     */
    Optional<ThingResponse> update(String tenantId, ThingUpdate thingUpdate) throws ConstraintViolationException;

    /**
     * Finds a thing of TYPE matching a specified URN in the realm of a given tenant.
     *
     * @param tenantId the tenant ID
     * @param type the thing TYPE
     * @param urn the thing URN
     * @return the {@link ThingResponse} instance for the retrieved thing or {@code empty} if the thing does not exist
     */
    Optional<ThingResponse> findByTypeAndUrn(String tenantId, String type, String urn);

    /**
     * Finds things of TYPE matching a specified URN start in the realm of a given tenant.
     *
     * @param tenantId the tenant ID
     * @param type the thing TYPE
     * @param urnStartsWith the first characters of the thing URN
     * @param page the number of the results page
     * @param size the size of a results page*
     * @return all things whose {@code urn} starts with {@code urnStartsWith}
     */
    List<ThingResponse> findByTypeAndUrnStartsWith(
        String tenantId,
        String type,
        String urnStartsWith,
        Long page, Long size);

    /**
     * Finds a thing matching a specified URN in the realm of a given tenant.
     *
     * @param tenantId the tenant ID
     * @param id the thing's system-assigned ID
     * @return the {@link ThingResponse} instance for the retrieved thing or {@code empty} if the thing does not exist
     */
    Optional<ThingResponse> findById(String tenantId, String id);

    /**
     * Finds all things matching an input collection of URNs in the realm of a given tenant.
     *
     * @param tenantId the tenant ID
     * @param ids a collection of system-assigned IDs
     * @param page the number of the results page
     * @param size the size of a results page*
     * @return a List of Optional<ThingResponse>, some of which may be empty.
     */
    List<Optional<ThingResponse>> findByIds(String tenantId, Collection<String> ids, Long page, Long size);

    /**
     * Return all things in the realm of a given tenant.
     *
     * @param tenantId the tenant ID
     * @param page the number of the results page
     * @param size the size of a results page
     * @return
     */
    List<ThingResponse> findAll(String tenantId, Long page, Long size);

    /**
     * Deletes a thing matching a specified ID in the realm of a given tenant.
     *
     * @param tenantId  the tenant ID
     * @param id the thing's system-assigned ID
     * @return the {@link ThingResponse} instance for the deleted thing or {@code empty} if the thing did not exist
     */
    Optional<ThingResponse> deleteById(String tenantId, String id);

    /**
     * Deletes a thing matching a specified type and URN in the realm of a given tenant.
     *
     * @param tenantId  the tenant ID
     * @param type the thing TYPE
     * @param urn the thing URN
     * @return the {@link ThingResponse} instance for the deleted thing or {@code empty} if the thing did not exist
     */
    Optional<ThingResponse> deleteByTypeAndUrn(String tenantId, String type, String urn);
}
