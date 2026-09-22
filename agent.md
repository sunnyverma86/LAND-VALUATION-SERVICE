# Historical Land Output CRUD - Agent Specification

## Objective
Implement CRUD operations against historical PostgreSQL tables whose names are stored in `audit_log.historical_table`.

## Existing context
- Spring Boot application package: `com.areap2`
- Database schema: `kau`
- Audit table: `audit_log`
- Audit repository method: `findByLoginIdAndHistoricalTableIsNotNullOrderByIdDesc`
- Historical table format: `land_master_outputYYYY_MM_DD_HH_mm_ss`

## Functional requirements
1. Accept `loginId` and list historical tables associated with that login.
2. Allow a user to select one validated historical table.
3. Support list, find-by-id, create, update, and delete.
4. Do not accept arbitrary schema/table names.
5. Permit only known land output columns in create/update payloads.
6. Return HTTP 404-equivalent service errors for missing records; map these exceptions globally in production.

## API
- `GET /api/historical-land-output/tables?loginId=ashwini`
- `GET /api/historical-land-output/{tableName}?loginId=ashwini`
- `GET /api/historical-land-output/{tableName}/{id}?loginId=ashwini`
- `POST /api/historical-land-output/{tableName}?loginId=ashwini`
- `PUT /api/historical-land-output/{tableName}/{id}?loginId=ashwini`
- `DELETE /api/historical-land-output/{tableName}/{id}?loginId=ashwini`

## Implementation
Use `NamedParameterJdbcTemplate` for dynamic table access. Table names cannot be bind parameters, so they must be validated using a strict regex and authorized against audit-log records before SQL construction. Values must remain bound parameters.

## Security and operational notes
- Replace query-string `loginId` with the authenticated principal when authentication integration is finalized.
- Consider restricting DELETE and UPDATE by role.
- Add a global exception handler and audit every mutation.
- Add integration tests against PostgreSQL before production deployment.
- Verify whether historical tables use an identity/sequence for `id`; create currently returns the inserted row only if the caller supplies an id, so production code should use `INSERT ... RETURNING id` for generated IDs.
