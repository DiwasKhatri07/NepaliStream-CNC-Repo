package com.cinefreak;

import com.lagradost.cloudstream3.utils.Qualities;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Cinefreak/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001¨\u0006\b"}, d2 = {"cleanTitle", "", "raw", "getIndexQuality", "", "str", "getBaseUrl", "url", "Cinefreak"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/cinefreak/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n1#2:66\n*E\n"})
public final class UtilsKt {
    @NotNull
    public static final String cleanTitle(@NotNull String raw) {
        String season;
        String name = new Regex("\\s+").replace(StringsKt.trim(StringsKt.substringBefore$default(raw, "(", (String) null, 2, (Object) null)).toString(), " ");
        if (name.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char it = name.charAt(0);
            StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase(it) ? CharsKt.titlecase(it) : String.valueOf(it)));
            String strSubstring = name.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            name = sbAppend.append(strSubstring).toString();
        }
        Regex seasonRegex = new Regex("Season\\s*\\d+", RegexOption.IGNORE_CASE);
        Regex yearRegex = new Regex("\\b(19|20)\\d{2}\\b");
        MatchResult matchResultFind$default = Regex.find$default(seasonRegex, raw, 0, 2, (Object) null);
        if (matchResultFind$default == null || (season = matchResultFind$default.getValue()) == null) {
            season = null;
        } else {
            if (season.length() > 0) {
                StringBuilder sb2 = new StringBuilder();
                String strValueOf = String.valueOf(season.charAt(0));
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                StringBuilder sbAppend2 = sb2.append((Object) upperCase);
                String strSubstring2 = season.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                season = sbAppend2.append(strSubstring2).toString();
            }
        }
        MatchResult matchResultFind$default2 = Regex.find$default(yearRegex, raw, 0, 2, (Object) null);
        String year = matchResultFind$default2 != null ? matchResultFind$default2.getValue() : null;
        List parts = new ArrayList();
        if (season != null) {
            parts.add(season);
        }
        if (year != null) {
            parts.add(year);
        }
        if (parts.isEmpty()) {
            return name;
        }
        return name + CollectionsKt.joinToString$default(parts, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cinefreak.UtilsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return UtilsKt.cleanTitle$lambda$2((String) obj);
            }
        }, 30, (Object) null);
    }

    static final CharSequence cleanTitle$lambda$2(String it) {
        return " (" + it + ')';
    }

    public static final int getIndexQuality(@Nullable String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4})[pP]"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
    }

    @NotNull
    public static final String getBaseUrl(@NotNull String url) {
        Url it = URLUtilsKt.Url(url);
        return it.getProtocol().getName() + "://" + it.getHost();
    }
}
