package com.dotseven.portfolio.domain

import com.dotseven.portfolio.domain.constant.SkillType
import com.dotseven.portfolio.domain.entity.*
import com.dotseven.portfolio.domain.repository.*
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

private val logger = KotlinLogging.logger {}


@Component
@Profile(value = ["default"])
class DataInitializer(
    private var achievementRepository: AchievementRepository,
    private var introductionRepository: IntroductionRepository,
    private var linkRepository: LinkRepository,
    private var skillRepository: SkillRepository,
    private var projectRepository: ProjectRepository,
    private var experienceRepository: ExperienceRepository
) {

    @PostConstruct
    fun initializeData() {

        logger.info { "--initializeData 실행 위치 확인 로그--" }

        var achievements = mutableListOf<Achievement>(
                Achievement(
                    title = "2024 Catkao 해커톤 최우수상",
                    description = "고양이 쇼핑몰 검색 서비스의 아키택처, 데이터 모델링 구현",
                    host = "캣카오",
                    achievedDate = LocalDate.of(2024, 11, 25),
                    isActive = true
                ),
                Achievement(
                    title = "정보처리기사",
                    description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                    host = "한국산업인력공단",
                    achievedDate = LocalDate.of(2024, 11, 25),
                    isActive = true
                )
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
            Introduction(content = "주도적으로 문제를 찾고, 해결하는 고양이 입니다.", isActive = true),
            Introduction(content = "기술을 위한 기술이 아닌, 비지니스 문제를 풀기 위한 기술을 추구합니다.", isActive = true),
            Introduction(content = "기존 소스를 리펙토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.", isActive = true),
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/5dotseven", isActive = true),
            Link(name = "blog", content = "https://velog.io/@5dotseven/posts", isActive = true),
        )
        linkRepository.saveAll(links)

        var experience1 = Experience(
            title = "수원대학교",
            description = "융합화학산업",
            startYear = 2015,
            startMonth = 3,
            endYear = 2022,
            endMonth = 8,
            isActive = true
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "GPA 3.0/4.5", isActive = true)
            )
        )

        var experience2 = Experience(
            title = "웨인테크놀로지",
            description = "핀테크개발자",
            startYear = 2024,
            startMonth = 9,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "레거시 php 여신업무 유지보수", isActive = true),
                ExperienceDetail(content = "라라벨 여신업무 유지보수", isActive = true)
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        var java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        var php = Skill(name = "Php", type = SkillType.LANGUAGE.name, isActive = true)
        var spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        var laravel = Skill(name = "Laravel", type = SkillType.FRAMEWORK.name, isActive = true)
        var mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
        var oracleDB = Skill(name = "oracleDB", type = SkillType.DATABASE.name, isActive = true)
        var redis = Skill(name = "redis", type = SkillType.DATABASE.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, php, spring, laravel, mysql, oracleDB))

        val project1 = Project(
            name = "SANTA(위치기반 등산 모임 서비스)",
            description = "실시간 위치를 기반으로 등산 인증을 하며, 등산을 좋아하는 사람들끼리 모임을 할 수 있는 서비스",
            startYear = 2024,
            startMonth = 4,
            endYear = 2024,
            endMonth = 5,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "test", url = null, isActive = true),
                ProjectDetail(content = "test2", url = null, isActive = true),
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = redis),
            )
        )

        val project2 = Project(
            name = "MurthHelp(쇼핑몰)",
            description = "드라마 킬러들의 쇼핑몰에서 영감을 받아, 각기 다른 권한을 가진 사용자들이 특정 카테고리의 물품을 구매할 수 있는 쇼핑몰",
            startYear = 2024,
            startMonth = 2,
            endYear = 2024,
            endMonth = 3,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "test3", url = null, isActive = true),
                ProjectDetail(content = "test4", url = null, isActive = true),
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = java),
                ProjectSkill(project = project2, skill = spring),
                ProjectSkill(project = project2, skill = mysql),
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))

    }


}