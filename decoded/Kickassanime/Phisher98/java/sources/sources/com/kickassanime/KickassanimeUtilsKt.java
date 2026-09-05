package com.kickassanime;

import com.lagradost.cloudstream3.utils.SubtitleHelper;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KickassanimeUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kickassanime/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u001a\u0016\u0010\r\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001¨\u0006\u000f"}, d2 = {"decode", "", "input", "createSlug", "getTrackerTitle", "getImageUrl", "link", "getThumbnailUrl", "getBannerUrl", "getBaseUrl", "url", "getLanguage", "language", "fixUrl", "domain", "Kickassanime"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class KickassanimeUtilsKt {
    @NotNull
    public static final String decode(@NotNull String input) {
        return StringsKt.replace$default(URLDecoder.decode(input, "utf-8"), " ", "%20", false, 4, (Object) null);
    }

    @NotNull
    public static final String createSlug(@NotNull String $this$createSlug) {
        String lowerCase = StringsKt.replace$default(new Regex("[^\\w ]+").replace($this$createSlug, ""), " ", "-", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @NotNull
    public static final String getTrackerTitle(@NotNull String $this$getTrackerTitle) {
        String blacklist = ArraysKt.joinToString$default(new String[]{"Dub", "Uncensored", "TV", "JPN DUB", "Uncensored"}, "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.kickassanime.KickassanimeUtilsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return KickassanimeUtilsKt.getTrackerTitle$lambda$0((String) obj);
            }
        }, 30, (Object) null);
        return StringsKt.trim(new Regex(blacklist).replace($this$getTrackerTitle, "")).toString();
    }

    static final CharSequence getTrackerTitle$lambda$0(String it) {
        return "\\(" + it + "\\)";
    }

    @Nullable
    public static final String getImageUrl(@Nullable String link) {
        if (link == null) {
            return null;
        }
        return StringsKt.startsWith$default(link, Kickassanime.INSTANCE.getMainUrl(), false, 2, (Object) null) ? link : Kickassanime.INSTANCE.getMainUrl() + "/image/poster/" + link + ".webp";
    }

    @Nullable
    public static final String getThumbnailUrl(@Nullable String link) {
        if (link == null) {
            return null;
        }
        return StringsKt.startsWith$default(link, Kickassanime.INSTANCE.getMainUrl(), false, 2, (Object) null) ? link : Kickassanime.INSTANCE.getMainUrl() + "/image/thumbnail/" + link + ".webp";
    }

    @Nullable
    public static final String getBannerUrl(@Nullable String link) {
        if (link == null) {
            return null;
        }
        return StringsKt.startsWith$default(link, Kickassanime.INSTANCE.getMainUrl(), false, 2, (Object) null) ? link : Kickassanime.INSTANCE.getMainUrl() + "/image/banner/" + link + ".webp";
    }

    @NotNull
    public static final String getBaseUrl(@NotNull String url) {
        URI it = new URI(url);
        return it.getScheme() + "://" + it.getHost();
    }

    @Nullable
    public static final String getLanguage(@Nullable String language) {
        SubtitleHelper subtitleHelper = SubtitleHelper.INSTANCE;
        if (language == null) {
            return null;
        }
        String strFromTagToEnglishLanguageName = subtitleHelper.fromTagToEnglishLanguageName(language);
        if (strFromTagToEnglishLanguageName != null) {
            return strFromTagToEnglishLanguageName;
        }
        return SubtitleHelper.INSTANCE.fromTagToEnglishLanguageName(StringsKt.substringBefore$default(language, "-", (String) null, 2, (Object) null));
    }

    @NotNull
    public static final String fixUrl(@NotNull String url, @NotNull String domain) {
        if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
            return url;
        }
        if (url.length() == 0) {
            return "";
        }
        boolean startsWithNoHttp = StringsKt.startsWith$default(url, "//", false, 2, (Object) null);
        if (startsWithNoHttp) {
            return "https:" + url;
        }
        if (StringsKt.startsWith$default(url, '/', false, 2, (Object) null)) {
            return domain + url;
        }
        return domain + '/' + url;
    }
}
