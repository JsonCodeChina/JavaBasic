package lombokTest;


import com.sun.istack.internal.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Book {
    private @Getter Integer id;
    private @Getter@Setter  String username;
    private @Getter double price;
    private @NotNull String author;
}
