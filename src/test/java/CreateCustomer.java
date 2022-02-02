import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateCustomer {
    private String name;
    private String job;
}