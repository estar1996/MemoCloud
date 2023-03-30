package Spring.demo.service;

import Spring.demo.domain.MemoPage;
import Spring.demo.repository.MemoPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemoPageService {
    @Autowired
    private MemoPageRepository memoPageRepository;

    public List<MemoPage> findAll() {
        return memoPageRepository.findAll();
    }
    public Optional<MemoPage> findById(Long id) {
        return memoPageRepository.findById(id);
    }

    public MemoPage save(MemoPage memoPage) {
        return memoPageRepository.save(memoPage);
    }
    public void deleteById(Long id) {
        memoPageRepository.deleteById(id);
    }
}
