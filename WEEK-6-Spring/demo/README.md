# Student Enrollment

Added an endpoint so a student can sign up for a course, using DTOs for the request and response.

## Endpoint

`POST /api/students/{id}/enrollments` enrolls student `{id}` in a course and returns `201 Created`.

```json
// Request
{ "course_id": 1, "grade": "A" }

// Response
{
  "id": 5,
  "studentId": 4,
  "studentName": "xyz abcd",
  "courseId": 1,
  "courseName": "Java",
  "enrollmentDate": "2026-10-11",
  "grade": "A"
}
```

## DTOs

- **`EnrollmentWriteDto`** (request): `course_id` (required) and `grade` (optional). The student id comes from the URL, and the date is set to today by the server.
- **`EnrollmentResponseDto`** (response): a flat summary of the saved enrollment. It is used instead of returning the `Enrollment` entity, which avoids infinite JSON loops.

## What I changed

- **Controller:** added `enrollStudent` in `StudentController`.
- **Service:** added `enrollStudent` in `StudentService`. It finds the student and the course, returning a 404 if either is missing, then saves the enrollment.
- **Entities:** added `@JsonIgnore` on `enrollments` in `Student` and `Course`.
