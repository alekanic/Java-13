import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findQueryInTheTask() {
        Task task = new Task(5);
        task.matches("Позвонить");
    }

    @Test
    public void findQueryInTheSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(63, "Покормить котов");

        Task task = new Task(63);
        task.matches("Кот");
    }

    @Test
    public void findQueryInTheEpic() {
        String[] subtasks = {"Бег", "Пресс", "Приседания", "Бокс"};

        Epic epic = new Epic(100, subtasks);

        Task task = new Task(100);
        task.matches("Бокс");
    }
}
