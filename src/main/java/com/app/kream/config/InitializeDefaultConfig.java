//package com.app.kream.config;
//
//import com.app.kream.domain.*;
//import com.app.kream.repository.MemberRepository;
//import com.app.kream.repository.ProductRepository;
//import com.app.kream.repository.ScrapRepository;
//import com.app.kream.repository.StyleImageRepository;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVRecord;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.io.FileReader;
//import java.io.Reader;
//import java.util.Arrays;
//
//
///**
// * 초기 상태 등록 Config
// */
//@Component
//@RequiredArgsConstructor
////@Profile(value = "!test") // test 에서는 제외
//public class InitializeDefaultConfig implements ApplicationRunner {
//
//    private final MemberRepository memberRepository;
//    private final ProductRepository productRepository;
//    private final ScrapRepository scrapRepository;
//    private final StyleImageRepository styleImageRepository;
//
//
//    public void saveMember(){
//        Member member = Member.builder()
//                .name("kihoon")
//                .age(20)
//                .build();
//
//        memberRepository.save(member);
//    }
//
//    public void saveProduct(){
//        try (Reader reader = new FileReader("build/resources/main/db.csv")) {
//            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
//                    .withFirstRecordAsHeader()
//                    .withIgnoreHeaderCase()
//                    .withTrim());
//
//            for (CSVRecord record : csvParser) {
//                Product product = Product.builder()
//                        .thumbnailUrl(record.get("thumbnailUrl"))
//                        .price(record.get("price"))
//                        .engTitle(record.get("engTitle"))
//                        .title(record.get("title"))
//                        .recentPrice(record.get("recentPrice"))
//                        .variablePrice(record.get("variablePrice"))
//                        .variablePercent(record.get("variablePercent"))
//                        .releasePrice(record.get("releasePrice"))
//                        .modelNumber(record.get("modelName")) // CSV에서의 'modelName'을 'modelNumber'로 매핑
//                        .releaseDate(record.get("releaseDate")) // releaseDate가 CSV에 없으므로 이 부분은 처리가 필요
//                        .styleCount(record.get("styleCount"))
//                        .status(ProductStatus.valueOf(record.get("status"))) // status 처리 필요
//                        .transactionCount(record.get("transaction")) // transactionCount 처리 필요
//                        .brandTitle(record.get("brand")) // brandTitle 처리 필요
//                        .isFast(Boolean.parseBoolean(record.get("isFast")))
//                        .colorBest(record.get("bestColor"))
//                        .recentPrice(record.get("recentPrice"))
//                        .scrapCount(record.get("scrapCount"))
//                        .build();
//                productRepository.save(product);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveStyleImage(){
//        StyleImage styleImage = StyleImage.builder()
//                .imageUrl("https://github.com/NOW-SOPT-APP4-KREAM/KREAM-Server/blob/main/image/styleview/Frame%20509.png")
//                .isVideo(false)
//                .product(productRepository.findById(1L).orElseThrow(()->new RuntimeException()))
//                .build();
//        StyleImage styleImage1 = StyleImage.builder()
//                .imageUrl("https://github.com/NOW-SOPT-APP4-KREAM/KREAM-Server/blob/main/image/styleview/Frame%20510.png")
//                .isVideo(true)
//                .product(productRepository.findById(1L).orElseThrow(()->new RuntimeException()))
//                .build();
//        StyleImage styleImage2 = StyleImage.builder()
//                .imageUrl("https://github.com/NOW-SOPT-APP4-KREAM/KREAM-Server/blob/main/image/styleview/Frame%20511.png")
//                .isVideo(false)
//                .product(productRepository.findById(1L).orElseThrow(()->new RuntimeException()))
//                .build();
//        StyleImage styleImage3 = StyleImage.builder()
//                .imageUrl("https://github.com/NOW-SOPT-APP4-KREAM/KREAM-Server/blob/main/image/styleview/Frame%20512.png")
//                .isVideo(false)
//                .product(productRepository.findById(1L).orElseThrow(()->new RuntimeException()))
//                .build();
//        StyleImage styleImage4 = StyleImage.builder()
//                .imageUrl("https://github.com/NOW-SOPT-APP4-KREAM/KREAM-Server/blob/main/image/styleview/Frame%20513.png")
//                .isVideo(false)
//                .product(productRepository.findById(1L).orElseThrow(()->new RuntimeException()))
//                .build();
//        StyleImage styleImage5 = StyleImage.builder()
//                .imageUrl("https://github.com/NOW-SOPT-APP4-KREAM/KREAM-Server/blob/main/image/styleview/Frame%20514.png")
//                .isVideo(false)
//                .product(productRepository.findById(1L).orElseThrow(()->new RuntimeException()))
//                .build();
//        StyleImage styleImage6 = StyleImage.builder()
//                .imageUrl("https://github.com/NOW-SOPT-APP4-KREAM/KREAM-Server/blob/main/image/styleview/Frame%20515.png")
//                .isVideo(true)
//                .product(productRepository.findById(1L).orElseThrow(()->new RuntimeException()))
//                .build();
//
//        StyleImage styleImage7 = StyleImage.builder()
//                .imageUrl("https://github.com/NOW-SOPT-APP4-KREAM/KREAM-Server/blob/main/image/styleview/Frame%20516.png")
//                .isVideo(false)
//                .product(productRepository.findById(1L).orElseThrow(()->new RuntimeException()))
//                .build();
//        StyleImage styleImage8 = StyleImage.builder()
//                .imageUrl("https://github.com/NOW-SOPT-APP4-KREAM/KREAM-Server/blob/main/image/styleview/Frame%20517.png")
//                .isVideo(true)
//                .product(productRepository.findById(1L).orElseThrow(()->new RuntimeException()))
//                .build();
//        StyleImage styleImage9 = StyleImage.builder()
//                .imageUrl("https://github.com/NOW-SOPT-APP4-KREAM/KREAM-Server/blob/main/image/styleview/Frame%20789.png")
//                .isVideo(false)
//                .product(productRepository.findById(1L).orElseThrow(()->new RuntimeException()))
//                .build();
//
//        styleImageRepository.saveAll(Arrays.asList(styleImage, styleImage2, styleImage3, styleImage4, styleImage5, styleImage6, styleImage7, styleImage8, styleImage9));
//    }
////    @Bean
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        saveMember();
//        saveProduct();
//        saveStyleImage();
//    }
//}
