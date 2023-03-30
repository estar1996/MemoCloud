package Spring.demo.controller;

import Spring.demo.domain.MemoPage;
import Spring.demo.service.MemoPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memo-pages")
public class MemoPageController {

    @Autowired
    private MemoPageService memoPageService;

    @GetMapping
    public ResponseEntity<List<MemoPage>> getAllMemoPages() {
        return new ResponseEntity<>(memoPageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemoPage> getMemoPageById(@PathVariable Long id) {
        return memoPageService.findById(id)
                .map(memoPage -> new ResponseEntity<>(memoPage, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<MemoPage> createMemoPage(@RequestBody MemoPage memoPage) {
        return new ResponseEntity<>(memoPageService.save(memoPage), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemoPage> updateMemoPage(@PathVariable Long id, @RequestBody MemoPage updatedMemoPage) {
        return memoPageService.findById(id).map(memoPage -> {
            memoPage.setTitle(updatedMemoPage.getTitle());
            memoPage.setContent(updatedMemoPage.getContent());
            memoPage.setWorkspace(updatedMemoPage.getWorkspace());
            return new ResponseEntity<>(memoPageService.save(memoPage), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemoPage(@PathVariable Long id) {
        memoPageService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}