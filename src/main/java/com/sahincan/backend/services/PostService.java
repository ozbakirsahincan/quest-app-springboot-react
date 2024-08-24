package com.sahincan.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahincan.backend.entities.Post;
import com.sahincan.backend.entities.User;
import com.sahincan.backend.repositories.PostRepository;
import com.sahincan.backend.requests.PostCreateRequest;
import com.sahincan.backend.requests.PostUpdateRequest;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent())
            return postRepository.findByUserId(userId.get());

        return postRepository.findAll();
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {

        /*
         * User'ın gerçekten var olup olmadığını bilmemiz gerekiyor
         * user ı aramak için userService sınıfını çağırıyoruz
         * userServicenin altındaki getOneUser methodu repository sınıfıyla bağlantılı
         * çalışıyor
         * getOneUser methodu veritabanına findAll methodu aracıyla
         * select * from user where id = (dışarıdan gönderilen userId) sorgusunu
         * çalıştıracak
         * dışarıdan gönderilen userId Post yaratılmak için verilen request in
         * bodysinden aldığımız id değeridir.
         * 
         * sorgudan gelen değer eğer gerçek bir değerse yeni bir post oluşturabiliriz.
         * Öncelikle yen bir Post sınıfı taslak örneği oluşturuyoruz.
         * Post sınıfında User bağlamı dışında id,title ve text sınıfları var .
         * Bu bağlam sadece Post create edilirken validasyon ve dışarıya yansıtmamız
         * gerekirken kullanacağımız için
         * Yani yaratılmış postta bu örneğe ihtiyaç duymadığımız için sadece Post create
         * edilirken ihtiyaç duyduğumuz
         * verilerle çalışabilmemiz için PostCreateRequest adında bir request dto sınıfı
         * oluşturuyoruz.
         * bu sınıfa bağlam dışındaki verileri içerdiği için yaratılmış postta bu
         * verileri kullanıyoruz.
         * oluşturulan Post sınıfı taslak örneğine PostCreateRequest altındaki değerleri
         * eşitliyoruz ve taslağı tamamlıyoruz.
         * 
         * Sonra Post nesnesi user nesnesine bağlı olduğu için daha önce varlığını
         * kontrol ettiğimiz
         * user nesnesini Post nesnesine ekliyoruz.
         * 
         * En son oluşturduğumuz taslağı veri tabanına kaydederek Post nesnesini veri
         * tabanında oluşturuyoruz
         * 
         */

        // Record sınıflı hali
        User user = userService.getOneUser(newPostRequest.userId());
        if (user == null)
            return null;

        Post toSave = new Post();
        toSave.setId(newPostRequest.id());
        toSave.setText(newPostRequest.text());
        toSave.setTitle(newPostRequest.title());
        toSave.setUser(user);
        return postRepository.save(toSave);

        // Lomboklu Class hali
        // User user = userService.getOneUser(newPostRequest.getUserId());
        // if (user == null)
        // return null;

        // Post toSave = new Post();
        // toSave.setId(newPostRequest.getId());
        // toSave.setText(newPostRequest.getText());
        // toSave.setTitle(newPostRequest.getTitle());
        // toSave.setUser(user);
        // return postRepository.save(toSave);

    }

    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);

        if(post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }

        return null;
    }

    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }

}
