package com.dudefilms;

import com.lagradost.cloudstream3.SearchQuality;
import java.text.Normalizer;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/DudeFilms/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001¨\u0006\n"}, d2 = {"cleanTitle", "", "raw", "isBlockedButton", "", "a", "Lorg/jsoup/nodes/Element;", "getSearchQuality", "Lcom/lagradost/cloudstream3/SearchQuality;", "check", "DudeFilms"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/dudefilms/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n1#2:100\n1960#3,3:101\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/dudefilms/UtilsKt\n*L\n56#1:101,3\n*E\n"})
public final class UtilsKt {
    /* JADX WARN: Code duplicated, block: B:21:0x006e  */
    @NotNull
    public static final String cleanTitle(@Nullable String raw) {
        Integer epEnd;
        StringBuilder sb;
        StringBuilder sbAppend;
        List groupValues;
        Regex regex = new Regex("S(\\d+)[Ee](\\d+)(?:-(\\d+))?");
        MatchResult match = Regex.find$default(regex, raw == null ? "" : raw, 0, 2, (Object) null);
        if (match == null) {
            Intrinsics.checkNotNull(raw);
            return StringsKt.trim(raw).toString();
        }
        int season = Integer.parseInt((String) match.getGroupValues().get(1));
        int epStart = Integer.parseInt((String) match.getGroupValues().get(2));
        String it = (String) CollectionsKt.getOrNull(match.getGroupValues(), 3);
        if (it == null) {
            epEnd = null;
        } else {
            if (!(it.length() > 0)) {
                it = null;
            }
            if (it != null) {
                epEnd = Integer.valueOf(Integer.parseInt(it));
            } else {
                epEnd = null;
            }
        }
        String strSubstringBefore$default = raw != null ? StringsKt.substringBefore$default(raw, match.getValue(), (String) null, 2, (Object) null) : null;
        Intrinsics.checkNotNull(strSubstringBefore$default);
        String showName = StringsKt.trim(strSubstringBefore$default).toString();
        MatchResult matchResultFind$default = Regex.find$default(new Regex("\\((\\d{4})\\)"), raw, 0, 2, (Object) null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
        }
        if (epEnd != null) {
            sb = new StringBuilder();
            sbAppend = sb.append("Episodes ").append(epStart).append('-').append(epEnd.intValue());
        } else {
            sb = new StringBuilder();
            sbAppend = sb.append("Episode ").append(epStart);
        }
        String episodes = sbAppend.toString();
        return showName + " Season " + season + " | " + episodes;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0020  */
    public static final boolean isBlockedButton(@NotNull Element a) {
        String text;
        String strText;
        Element elementSelectFirst = a.selectFirst("span.mb-text");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null) {
            text = a.text().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(text, "toLowerCase(...)");
        } else {
            text = strText.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(text, "toLowerCase(...)");
            if (text == null) {
                text = a.text().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(text, "toLowerCase(...)");
            }
        }
        Iterable $this$any$iv = CollectionsKt.listOf(new String[]{"zipfile", "torrent", "rar", "7z"});
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            String it = (String) element$iv;
            if (StringsKt.contains$default(text, it, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final SearchQuality getSearchQuality(@Nullable String check) {
        if (check == null) {
            return null;
        }
        String u = Normalizer.normalize(check, Normalizer.Form.NFKC).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(u, "toLowerCase(...)");
        List<Pair> patterns = CollectionsKt.listOf(new Pair[]{TuplesKt.to(new Regex("\\b(4k|ds4k|uhd|2160p)\\b", RegexOption.IGNORE_CASE), SearchQuality.FourK), TuplesKt.to(new Regex("\\b(hdts|hdcam|hdtc)\\b", RegexOption.IGNORE_CASE), SearchQuality.HdCam), TuplesKt.to(new Regex("\\b(camrip|cam[- ]?rip)\\b", RegexOption.IGNORE_CASE), SearchQuality.CamRip), TuplesKt.to(new Regex("\\b(cam)\\b", RegexOption.IGNORE_CASE), SearchQuality.Cam), TuplesKt.to(new Regex("\\b(web[- ]?dl|webrip|webdl)\\b", RegexOption.IGNORE_CASE), SearchQuality.WebRip), TuplesKt.to(new Regex("\\b(bluray|bdrip|blu[- ]?ray)\\b", RegexOption.IGNORE_CASE), SearchQuality.BlueRay), TuplesKt.to(new Regex("\\b(1440p|qhd)\\b", RegexOption.IGNORE_CASE), SearchQuality.BlueRay), TuplesKt.to(new Regex("\\b(1080p|fullhd)\\b", RegexOption.IGNORE_CASE), SearchQuality.HD), TuplesKt.to(new Regex("\\b(720p)\\b", RegexOption.IGNORE_CASE), SearchQuality.SD), TuplesKt.to(new Regex("\\b(hdrip|hdtv)\\b", RegexOption.IGNORE_CASE), SearchQuality.HD), TuplesKt.to(new Regex("\\b(dvd)\\b", RegexOption.IGNORE_CASE), SearchQuality.DVD), TuplesKt.to(new Regex("\\b(hq)\\b", RegexOption.IGNORE_CASE), SearchQuality.HQ), TuplesKt.to(new Regex("\\b(rip)\\b", RegexOption.IGNORE_CASE), SearchQuality.CamRip)});
        for (Pair pair : patterns) {
            Regex regex = (Regex) pair.component1();
            SearchQuality quality = (SearchQuality) pair.component2();
            if (regex.containsMatchIn(u)) {
                return quality;
            }
        }
        return null;
    }
}
