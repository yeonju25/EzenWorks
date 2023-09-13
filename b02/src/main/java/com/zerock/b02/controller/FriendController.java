package com.zerock.b02.controller;

import com.zerock.b02.domain.Friend;
import com.zerock.b02.dto.FriendDTO;
import com.zerock.b02.dto.PageRequestDTO;
import com.zerock.b02.dto.PageResponseDTO;
import com.zerock.b02.service.FriendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/friend")
@Log4j2
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        PageResponseDTO<FriendDTO> responseDTO = friendService.list(pageRequestDTO);
        log.info(responseDTO);
        model.addAttribute("responseDTO", responseDTO);
    }

    @GetMapping({"/read", "/modify"})
    public void readOne(Long fno, PageRequestDTO pageRequestDTO, Model model){
        FriendDTO friendDTO = friendService.readOne(fno);
        model.addAttribute("dto", friendDTO);
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO, @Valid FriendDTO friendDTO, BindingResult bindingResult, RedirectAttributes rttr){
        if(bindingResult.hasErrors()){
            log.info("errors");
            String link = pageRequestDTO.getLink();
            rttr.addFlashAttribute("errors", bindingResult.getAllErrors());
            rttr.addAttribute("fno", friendDTO.getFno());
            return "redirect:/board/modify?" + link;
        }


        friendService.modify(friendDTO);
        rttr.addFlashAttribute("result", "modified");
        rttr.addAttribute("fno",friendDTO.getFno());
        return "redirect:/friend/list";
    }

    @PostMapping("/remove")
    public String remove(Long fno){
        friendService.remove(fno);
        return "redirect:/friend/list";
    }

}
