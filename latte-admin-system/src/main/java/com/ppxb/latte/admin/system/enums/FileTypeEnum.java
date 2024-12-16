/*
 * MIT License
 *
 * Copyright (c) 2024 ppxb
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */



package com.ppxb.latte.admin.system.enums;

import cn.hutool.core.util.StrUtil;
import com.ppxb.latte.starter.core.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 文件类型枚举
 *
 * @author ppxb
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum FileTypeEnum implements BaseEnum<Integer> {

    UNKNOWN(1, "其他", Collections.emptyList()),

    IMAGE(2, "图片", List
        .of("jpg", "jpeg", "png", "gif", "bmp", "webp", "ico", "psd", "tiff", "dwg", "jxr", "apng", "xcf")),

    DOC(3, "文档", List.of("txt", "pdf", "doc", "xls", "ppt", "docx", "xlsx", "pptx")),

    VIDEO(4, "视频", List.of("mp4", "avi", "mkv", "flv", "webm", "wmv", "m4v", "mov", "mpg", "rmvb", "3gp")),

    AUDIO(5, "音频", List.of("mp3", "flac", "wav", "ogg", "midi", "m4a", "aac", "amr", "ac3", "aiff"));

    private final Integer value;

    private final String description;

    private final List<String> extensions;

    /**
     * 根据扩展名查询文件类型
     *
     * @param extension 扩展名
     * @return 文件类型
     */
    public static FileTypeEnum getByExtension(String extension) {
        return Arrays.stream(FileTypeEnum.values())
            .filter(e -> e.getExtensions().contains(StrUtil.emptyIfNull(extension).toLowerCase()))
            .findFirst()
            .orElse(UNKNOWN);
    }
}
