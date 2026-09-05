package com.Animexin;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animexin/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"Http", "", "url", "Animexin"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class ExtractorKt {
    @NotNull
    public static final String Http(@NotNull String url) {
        if (StringsKt.startsWith$default(url, "//", false, 2, (Object) null)) {
            return "https:" + url;
        }
        return url;
    }
}
