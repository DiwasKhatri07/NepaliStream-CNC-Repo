package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/KisskhProvider/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a,\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"TMDBAPI", "", "fetchtmdb", "", "title", "year", "isMovie", "", "(Ljava/lang/String;Ljava/lang/Integer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "KisskhProvider"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/phisher98/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n1#2:54\n*E\n"})
public final class UtilsKt {

    @NotNull
    public static final String TMDBAPI = "https://api.themoviedb.org/3";

    /* JADX INFO: renamed from: com.phisher98.UtilsKt$fetchtmdb$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0, 0}, l = {14}, m = "fetchtmdb", n = {"title", "year", "encodedTitle", "url", "isMovie"}, nl = {15}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.fetchtmdb(null, null, false, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public static final Object fetchtmdb(@Nullable String title, @Nullable Integer year, boolean isMovie, @NotNull Continuation<? super Integer> continuation) throws UnsupportedEncodingException {
        C00071 c00071;
        boolean z;
        String title2;
        Integer year2;
        boolean isMovie2;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = new C00071(continuation);
            }
        } else {
            c00071 = new C00071(continuation);
        }
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String str = title;
                if (str == null || StringsKt.isBlank(str)) {
                    return null;
                }
                String encodedTitle = URLEncoder.encode(title, "UTF-8");
                String url = "https://api.themoviedb.org/3/search/multi?api_key=1865f43a0549ca50d341dd9ab8b29f49&query=" + encodedTitle;
                Requests app = MainActivityKt.getApp();
                c00071.L$0 = title;
                c00071.L$1 = year;
                c00071.L$2 = SpillingKt.nullOutSpilledVariable(encodedTitle);
                c00071.L$3 = SpillingKt.nullOutSpilledVariable(url);
                c00071.Z$0 = isMovie;
                c00071.label = 1;
                z = false;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                title2 = title;
                year2 = year;
                isMovie2 = isMovie;
                break;
                break;
            case 1:
                isMovie2 = c00071.Z$0;
                year2 = (Integer) c00071.L$1;
                String title3 = (String) c00071.L$0;
                ResultKt.throwOnFailure($result);
                title2 = title3;
                z = false;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JSONObject json = new JSONObject(((NiceResponse) $result).getText());
        JSONArray results = json.optJSONArray("results");
        if (results == null) {
            return null;
        }
        int length = results.length();
        for (int i = 0; i < length; i++) {
            JSONObject item = results.optJSONObject(i);
            if (item != null && fetchtmdb$matches(isMovie2, title2, year2, item, z)) {
                return Boxing.boxInt(item.optInt("id"));
            }
        }
        int length2 = results.length();
        for (int i2 = 0; i2 < length2; i2++) {
            JSONObject item2 = results.optJSONObject(i2);
            if (item2 != null && fetchtmdb$matches(isMovie2, title2, year2, item2, true)) {
                return Boxing.boxInt(item2.optInt("id"));
            }
        }
        return null;
    }

    private static final boolean fetchtmdb$matches(boolean $isMovie, String $title, Integer $year, JSONObject item, boolean ignoreYear) {
        String resultTitle = item.optString($isMovie ? "title" : "name");
        String dateStr = item.optString($isMovie ? "release_date" : "first_air_date");
        Integer resultYear = null;
        String str = dateStr.length() >= 4 ? dateStr : null;
        if (str != null) {
            String strSubstring = str.substring(0, 4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            if (strSubstring != null) {
                resultYear = StringsKt.toIntOrNull(strSubstring);
            }
        }
        boolean titleMatches = StringsKt.equals(resultTitle, $title, true) || StringsKt.contains(resultTitle, $title, true) || StringsKt.contains($title, resultTitle, true);
        boolean yearMatches = ignoreYear || $year == null || resultYear == null || Intrinsics.areEqual($year, resultYear);
        return titleMatches && yearMatches;
    }
}
