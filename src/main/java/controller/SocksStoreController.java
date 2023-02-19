package controller;


import controller.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import model.Color;
import model.Size;
import model.SocksBatch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")
@Tag(name = "Api для учета носков", description = "Регистрация прихода, отпуск со склада, списание брака, подсчет количества")
@RequiredArgsConstructor
public class SocksStoreController {


    private final SocksStoreController storeService;

    @PostMapping
    @Operation(summary = "Регистрация прихода товара на склад")
    @ApiResponse(responseCode = "200", description = "Операция успешна")
    @ApiResponse(responseCode = "400", description = "Параметры запроса отсутствуют или имеют некорректный формат")
    @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны")
    public ResponseEntity<ResponseDto> accept(@RequestBody SocksBatch socksBatch) {
        storeService.accept(socksBatch);
        return ResponseEntity.ok(new ResponseDto("Носки успешно добавлены на склад"));
    }

    @PutMapping
    @Operation(summary = "Регистрирует отпуск носков со склад")
    @ApiResponse(responseCode = "200", description = "Операция успешна")
    @ApiResponse(responseCode = "400", description = "Параметры запроса отсутствуют или имеют некорректный формат")
    @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны")
    public ResponseEntity<ResponseDto> issuance(@RequestBody SocksBatch socksBatch) {
        int socksCount = storeService.issuance(socksBatch);
        return ResponseEntity.ok(new ResponseDto(socksCount + "Носков отпущено со склада"));



}

    @GetMapping
    @Operation(summary = "Возвращает общее количество носков на складе")
    @ApiResponse(responseCode = "200", description = "Операция успешна")
    @ApiResponse(responseCode = "400", description = "Параметры запроса отсутствуют или имеют некорректный формат")
    @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны")
    public ResponseEntity<ResponseDto> getCount(@RequestParam Color color,
                                                @RequestParam Size size,
                                                @RequestParam int cottonMin,
                                                @RequestParam int cottonMax) {
        int socksCount = storeService.getCount(color, size, cottonMin, cottonMax);
        return ResponseEntity.ok(new ResponseDto("Количество носков" + socksCount));
    }


    @DeleteMapping
    @Operation(summary = "Регистрирует списание бракованных носков")
    @ApiResponse(responseCode = "200", description = "Операция успешна")
    @ApiResponse(responseCode = "400", description = "Параметры запроса отсутствуют или имеют некорректный формат")
    @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны")
    public ResponseEntity<ResponseDto> reject(@RequestBody SocksBatch socksBatch) {
        int socksCount = storeService.reject(socksBatch);
        return ResponseEntity.ok(new ResponseDto(socksCount + "Носков отпущено со склада"));
    }
}
