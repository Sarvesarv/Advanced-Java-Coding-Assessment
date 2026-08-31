class StudentController {
    private Student model;

    public StudentController(Student model) {
        this.model = model;
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentCourse(String course) {
        model.setCourse(course);
    }

    public void updateView() {
        System.out.println("--- Student Details ---");
        System.out.println("ID: " + model.getId());
        System.out.println("Name: " + model.getName());
        System.out.println("Course: " + model.getCourse());
    }
}