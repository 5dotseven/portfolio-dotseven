package com.dotseven.portfolio.presentation.controller

import com.dotseven.portfolio.domain.constant.SkillType
import com.dotseven.portfolio.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.util.*

@Controller
class PresentationViewController(
    private val presentationService: PresentationService,
) {

    @GetMapping("/test")
    fun test(): String {
        return "test"
    }

    @GetMapping("/")
    fun index(model: Model): String {
        val introductions = presentationService.getIntroductions()
        model.addAttribute("introductions", introductions)

        val links = presentationService.getLinks()
        model.addAttribute("links", links)
        return "presentation/index"
    }

    @GetMapping("/resume")
    fun resume(model: Model): String {
        val resume = presentationService.getResume()
        val groupedSkills = resume.skills.groupBy { it.type }

        model.addAttribute("resume", resume)
        model.addAttribute("skillTypes", SkillType.values())
        model.addAttribute("groupedSkills", groupedSkills)

        val values = Arrays.toString(SkillType.values())
        println("스킬타입: $values")
        println("그룹스킬: $groupedSkills.keys")

        return "presentation/resume"
    }

    @GetMapping("/projects")
    fun getProjects(model: Model): String {
        val projects = presentationService.getProjects()
        model.addAttribute("projects", projects)

        return "presentation/projects"
    }
}