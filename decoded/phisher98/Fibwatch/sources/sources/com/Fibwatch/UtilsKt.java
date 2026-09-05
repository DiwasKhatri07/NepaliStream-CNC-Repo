package com.Fibwatch;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Fibwatch/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"}, d2 = {"cleanTitle", "", "raw", "parseSeasonEpisode", "Lcom/Fibwatch/EpisodeInfo;", "title", "Fibwatch"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/Fibwatch/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1#2:97\n*E\n"})
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
            sbAppend = sb.append("Episodes ").append(epStart).append((char) 8211).append(epEnd.intValue());
        } else {
            sb = new StringBuilder();
            sbAppend = sb.append("Episode ").append(epStart);
        }
        String episodes = sbAppend.toString();
        return showName + " Season " + season + " | " + episodes;
    }

    @NotNull
    public static final EpisodeInfo parseSeasonEpisode(@NotNull String title) {
        String t = title.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(t, "toLowerCase(...)");
        MatchResult full = Regex.find$default(new Regex("s(\\d{1,2})e(\\d{1,3})(?:-(\\d{1,3}))?"), t, 0, 2, (Object) null);
        if (full != null) {
            int season = Integer.parseInt((String) full.getGroupValues().get(1));
            int epStart = Integer.parseInt((String) full.getGroupValues().get(2));
            Object obj = full.getGroupValues().get(3);
            String it = (String) obj;
            if (StringsKt.isBlank(it)) {
                obj = null;
            }
            String str = (String) obj;
            Integer epEnd = str != null ? Integer.valueOf(Integer.parseInt(str)) : null;
            return new EpisodeInfo(Integer.valueOf(season), Integer.valueOf(epStart), epEnd);
        }
        MatchResult seasonOnly = Regex.find$default(new Regex("s(\\d{1,2})\\b"), t, 0, 2, (Object) null);
        if (seasonOnly != null) {
            int season2 = Integer.parseInt((String) seasonOnly.getGroupValues().get(1));
            return new EpisodeInfo(Integer.valueOf(season2), null, null);
        }
        MatchResult epOnly = Regex.find$default(new Regex("e(\\d{1,3})\\b"), t, 0, 2, (Object) null);
        if (epOnly != null) {
            int episode = Integer.parseInt((String) epOnly.getGroupValues().get(1));
            return new EpisodeInfo(null, Integer.valueOf(episode), null);
        }
        return new EpisodeInfo(null, null, null);
    }
}
