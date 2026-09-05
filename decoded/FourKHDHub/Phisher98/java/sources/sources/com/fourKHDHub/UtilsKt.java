package com.fourKHDHub;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import io.ktor.http.CodecsKt;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/FourKHDHub/classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a \u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000e\u001a\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u001a\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u001a^\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00170\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u001cH\u0086@¢\u0006\u0002\u0010 \u001a\u0017\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0007\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010$\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"REDIRECT_REGEX", "Lkotlin/text/Regex;", "getRedirectLinks", "", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "encode", "value", "pen", "fetchtmdb", "", "title", "isMovie", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseCredits", "", "Lcom/lagradost/cloudstream3/ActorData;", "jsonText", "getSearchQuality", "Lcom/lagradost/cloudstream3/SearchQuality;", "tags", "loadSourceNameExtractor", "", "source", "referer", "quality", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeScoreFrom10", "Lcom/lagradost/cloudstream3/Score;", "", "(Ljava/lang/Double;)Lcom/lagradost/cloudstream3/Score;", "FourKHDHub"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/fourKHDHub/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,199:1\n1#2:200\n*E\n"})
public final class UtilsKt {

    @NotNull
    private static final Regex REDIRECT_REGEX = new Regex("s\\('o','([A-Za-z0-9+/=]+)'|ck\\('_wp_http_\\d+','([^']+)'");

    /* JADX INFO: renamed from: com.fourKHDHub.UtilsKt$fetchtmdb$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.UtilsKt", f = "Utils.kt", i = {0, 0, 0}, l = {92}, m = "fetchtmdb", n = {"title", "url", "isMovie"}, nl = {93}, s = {"L$0", "L$1", "Z$0"}, v = 2)
    static final class C00171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00171(Continuation<? super C00171> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.fetchtmdb(null, false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.fourKHDHub.UtilsKt$getRedirectLinks$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.UtilsKt", f = "Utils.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {30, 62}, m = "getRedirectLinks", n = {"url", "url", "html", "combined", "decoded", "json", "encodedUrl", "data", "wp"}, nl = {29, 63}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00181(Continuation<? super C00181> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.getRedirectLinks(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.fourKHDHub.UtilsKt$loadSourceNameExtractor$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0, 0, 0}, l = {174}, m = "loadSourceNameExtractor", n = {"source", "url", "referer", "quality", "subtitleCallback", "callback"}, nl = {191}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00191(Continuation<? super C00191> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.loadSourceNameExtractor(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0138 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0114 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:44:0x011a  */
    /* JADX WARN: Code duplicated, block: B:46:0x012b  */
    /* JADX WARN: Code duplicated, block: B:58:0x0157  */
    /* JADX WARN: Code duplicated, block: B:59:0x0159  */
    /* JADX WARN: Code duplicated, block: B:61:0x015c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:68:0x01ac A[Catch: all -> 0x02a2, TRY_ENTER, TryCatch #1 {all -> 0x02a2, blocks: (B:62:0x015d, B:68:0x01ac, B:70:0x01c5, B:73:0x01de), top: B:100:0x015d }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01c5 A[Catch: all -> 0x02a2, TryCatch #1 {all -> 0x02a2, blocks: (B:62:0x015d, B:68:0x01ac, B:70:0x01c5, B:73:0x01de), top: B:100:0x015d }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:84:0x0289 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:94:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:96:0x02e2  */
    @Nullable
    public static final Object getRedirectLinks(@NotNull String url, @NotNull Continuation<? super String> continuation) {
        C00181 c00181;
        Object obj;
        String str;
        C00181 c00182;
        String url2;
        Object obj2;
        Object obj3;
        String url3;
        Throwable it;
        String string;
        StringBuilder combined;
        boolean z;
        String url4;
        JSONObject json;
        String encodedUrl;
        String wp;
        MatchGroup matchGroup;
        MatchGroup matchGroup2;
        String p0;
        String p1;
        Object obj4;
        Throwable it2;
        if (continuation instanceof C00181) {
            c00181 = (C00181) continuation;
            if ((c00181.label & Integer.MIN_VALUE) != 0) {
                c00181.label -= Integer.MIN_VALUE;
            } else {
                c00181 = new C00181(continuation);
            }
        } else {
            c00181 = new C00181(continuation);
        }
        C00181 c00183 = c00181;
        Object $result = c00183.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00183.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    c00183.L$0 = url;
                    c00183.label = 1;
                    str = "Error";
                    obj = coroutine_suspended;
                    try {
                        obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00183, 4094, (Object) null);
                        c00182 = c00183;
                        if (obj2 == obj) {
                            return obj;
                        }
                        url2 = url;
                        try {
                            obj3 = Result.constructor-impl(((NiceResponse) obj2).getText());
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        url3 = url2;
                        it = Result.exceptionOrNull-impl(obj3);
                        string = "";
                        if (it == null) {
                            Log.INSTANCE.e(str, "Failed to load redirect page: " + it.getMessage());
                            return "";
                        }
                        String html = (String) obj3;
                        combined = new StringBuilder(128);
                        for (MatchResult m : Regex.findAll$default(REDIRECT_REGEX, html, 0, 2, (Object) null)) {
                            matchGroup = m.getGroups().get(1);
                            if (matchGroup != null || (p1 = matchGroup.getValue()) == null || combined.append(p1) == null) {
                                matchGroup2 = m.getGroups().get(2);
                                if (matchGroup2 == null && (p0 = matchGroup2.getValue()) != null) {
                                    combined.append(p0);
                                }
                            }
                        }
                        if (combined.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            return "";
                        }
                        try {
                            Result.Companion companion3 = Result.Companion;
                            String decoded = MainAPIKt.base64Decode(pen(MainAPIKt.base64Decode(MainAPIKt.base64Decode(combined.toString()))));
                            json = new JSONObject(decoded);
                            encodedUrl = MainAPIKt.base64Decode(json.optString("o"));
                            if (StringsKt.isBlank(encodedUrl)) {
                                String data = encode(json.optString("data"));
                                wp = json.optString("blog_url");
                                if (!StringsKt.isBlank(wp) || StringsKt.isBlank(data)) {
                                    url4 = url3;
                                } else {
                                    Requests app2 = MainActivityKt.getApp();
                                    String str2 = wp + "?re=" + data;
                                    c00182.L$0 = url3;
                                    c00182.L$1 = SpillingKt.nullOutSpilledVariable(html);
                                    c00182.L$2 = SpillingKt.nullOutSpilledVariable(combined);
                                    c00182.L$3 = SpillingKt.nullOutSpilledVariable(decoded);
                                    c00182.L$4 = SpillingKt.nullOutSpilledVariable(json);
                                    c00182.L$5 = SpillingKt.nullOutSpilledVariable(encodedUrl);
                                    c00182.L$6 = SpillingKt.nullOutSpilledVariable(data);
                                    c00182.L$7 = SpillingKt.nullOutSpilledVariable(wp);
                                    c00182.label = 2;
                                    try {
                                        $result = Requests.get$default(app2, str2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00182, 4094, (Object) null);
                                        if ($result == obj) {
                                            return obj;
                                        }
                                        url4 = url3;
                                        try {
                                            string = StringsKt.trim(((NiceResponse) $result).getDocument().text()).toString();
                                        } catch (Throwable th2) {
                                            th = th2;
                                            Result.Companion companion4 = Result.Companion;
                                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        url4 = url3;
                                        Result.Companion companion5 = Result.Companion;
                                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                }
                                Result.Companion companion6 = Result.Companion;
                                obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                it2 = Result.exceptionOrNull-impl(obj4);
                                if (it2 == null) {
                                    return obj4;
                                }
                                Log.INSTANCE.e(str, "Error processing redirect: " + it2.getMessage());
                                return url4;
                            }
                            try {
                                string = StringsKt.trim(encodedUrl).toString();
                                url4 = url3;
                            } catch (Throwable th4) {
                                th = th4;
                                url4 = url3;
                                Result.Companion companion7 = Result.Companion;
                                obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            obj4 = Result.constructor-impl(string);
                            break;
                        } catch (Throwable th5) {
                            th = th5;
                            url4 = url3;
                        }
                        it2 = Result.exceptionOrNull-impl(obj4);
                        if (it2 == null) {
                            return obj4;
                        }
                        Log.INSTANCE.e(str, "Error processing redirect: " + it2.getMessage());
                        return url4;
                    } catch (Throwable th6) {
                        th = th6;
                        c00182 = c00183;
                        url2 = url;
                        Result.Companion companion8 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        url3 = url2;
                        it = Result.exceptionOrNull-impl(obj3);
                        string = "";
                        if (it == null) {
                            Log.INSTANCE.e(str, "Failed to load redirect page: " + it.getMessage());
                            return "";
                        }
                        String html2 = (String) obj3;
                        combined = new StringBuilder(128);
                        while (r0.hasNext()) {
                            matchGroup = m.getGroups().get(1);
                            if (matchGroup != null) {
                            }
                            matchGroup2 = m.getGroups().get(2);
                            if (matchGroup2 == null) {
                            }
                        }
                        if (combined.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            return "";
                        }
                        Result.Companion companion9 = Result.Companion;
                        String decoded2 = MainAPIKt.base64Decode(pen(MainAPIKt.base64Decode(MainAPIKt.base64Decode(combined.toString()))));
                        json = new JSONObject(decoded2);
                        encodedUrl = MainAPIKt.base64Decode(json.optString("o"));
                        if (StringsKt.isBlank(encodedUrl)) {
                            string = StringsKt.trim(encodedUrl).toString();
                            url4 = url3;
                        } else {
                            String data2 = encode(json.optString("data"));
                            wp = json.optString("blog_url");
                            if (StringsKt.isBlank(wp)) {
                            }
                            url4 = url3;
                        }
                        obj4 = Result.constructor-impl(string);
                        it2 = Result.exceptionOrNull-impl(obj4);
                        if (it2 == null) {
                            return obj4;
                        }
                        Log.INSTANCE.e(str, "Error processing redirect: " + it2.getMessage());
                        return url4;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    obj = coroutine_suspended;
                    str = "Error";
                    c00182 = c00183;
                    url2 = url;
                }
                break;
            case 1:
                url2 = (String) c00183.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = coroutine_suspended;
                    str = "Error";
                    c00182 = c00183;
                    obj2 = $result;
                    obj3 = Result.constructor-impl(((NiceResponse) obj2).getText());
                    break;
                } catch (Throwable th8) {
                    th = th8;
                    obj = coroutine_suspended;
                    str = "Error";
                    c00182 = c00183;
                    Result.Companion companion10 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                    url3 = url2;
                    it = Result.exceptionOrNull-impl(obj3);
                    string = "";
                    if (it == null) {
                        Log.INSTANCE.e(str, "Failed to load redirect page: " + it.getMessage());
                        return "";
                    }
                    String html3 = (String) obj3;
                    combined = new StringBuilder(128);
                    while (r0.hasNext()) {
                        matchGroup = m.getGroups().get(1);
                        if (matchGroup != null) {
                        }
                        matchGroup2 = m.getGroups().get(2);
                        if (matchGroup2 == null) {
                        }
                    }
                    if (combined.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return "";
                    }
                    Result.Companion companion11 = Result.Companion;
                    String decoded3 = MainAPIKt.base64Decode(pen(MainAPIKt.base64Decode(MainAPIKt.base64Decode(combined.toString()))));
                    json = new JSONObject(decoded3);
                    encodedUrl = MainAPIKt.base64Decode(json.optString("o"));
                    if (StringsKt.isBlank(encodedUrl)) {
                        string = StringsKt.trim(encodedUrl).toString();
                        url4 = url3;
                    } else {
                        String data3 = encode(json.optString("data"));
                        wp = json.optString("blog_url");
                        if (StringsKt.isBlank(wp)) {
                        }
                        url4 = url3;
                    }
                    obj4 = Result.constructor-impl(string);
                    it2 = Result.exceptionOrNull-impl(obj4);
                    if (it2 == null) {
                        return obj4;
                    }
                    Log.INSTANCE.e(str, "Error processing redirect: " + it2.getMessage());
                    return url4;
                }
                url3 = url2;
                it = Result.exceptionOrNull-impl(obj3);
                string = "";
                if (it == null) {
                    Log.INSTANCE.e(str, "Failed to load redirect page: " + it.getMessage());
                    return "";
                }
                String html4 = (String) obj3;
                combined = new StringBuilder(128);
                while (r0.hasNext()) {
                    matchGroup = m.getGroups().get(1);
                    if (matchGroup != null) {
                    }
                    matchGroup2 = m.getGroups().get(2);
                    if (matchGroup2 == null) {
                    }
                }
                if (combined.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return "";
                }
                Result.Companion companion12 = Result.Companion;
                String decoded4 = MainAPIKt.base64Decode(pen(MainAPIKt.base64Decode(MainAPIKt.base64Decode(combined.toString()))));
                json = new JSONObject(decoded4);
                encodedUrl = MainAPIKt.base64Decode(json.optString("o"));
                if (StringsKt.isBlank(encodedUrl)) {
                    string = StringsKt.trim(encodedUrl).toString();
                    url4 = url3;
                } else {
                    String data4 = encode(json.optString("data"));
                    wp = json.optString("blog_url");
                    if (StringsKt.isBlank(wp)) {
                    }
                    url4 = url3;
                }
                obj4 = Result.constructor-impl(string);
                it2 = Result.exceptionOrNull-impl(obj4);
                if (it2 == null) {
                    return obj4;
                }
                Log.INSTANCE.e(str, "Error processing redirect: " + it2.getMessage());
                return url4;
            case 2:
                url4 = (String) c00183.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    str = "Error";
                    string = StringsKt.trim(((NiceResponse) $result).getDocument().text()).toString();
                    obj4 = Result.constructor-impl(string);
                    break;
                } catch (Throwable th9) {
                    th = th9;
                    str = "Error";
                    Result.Companion companion13 = Result.Companion;
                    obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                it2 = Result.exceptionOrNull-impl(obj4);
                if (it2 == null) {
                    return obj4;
                }
                Log.INSTANCE.e(str, "Error processing redirect: " + it2.getMessage());
                return url4;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @NotNull
    public static final String encode(@NotNull String value) {
        return value.length() == 0 ? "" : MainAPIKt.base64Decode(value);
    }

    @NotNull
    public static final String pen(@NotNull String value) {
        char c;
        StringBuilder out = new StringBuilder(value.length());
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char c2 = value.charAt(i);
            if ('A' <= c2 && c2 < '[') {
                c = (char) ((((c2 - 'A') + 13) % 26) + 65);
            } else if ('a' <= c2 && c2 < '{') {
                c = (char) ((((c2 - 'a') + 13) % 26) + 97);
            } else {
                c = c2;
            }
            out.append(c);
        }
        return out.toString();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public static final Object fetchtmdb(@NotNull String title, boolean isMovie, @NotNull Continuation<? super Integer> continuation) {
        C00171 c00171;
        String title2;
        boolean z;
        String title3;
        boolean isMovie2;
        String str;
        if (continuation instanceof C00171) {
            c00171 = (C00171) continuation;
            if ((c00171.label & Integer.MIN_VALUE) != 0) {
                c00171.label -= Integer.MIN_VALUE;
            } else {
                c00171 = new C00171(continuation);
            }
        } else {
            c00171 = new C00171(continuation);
        }
        Object $result = c00171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00171.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url = "https://api.themoviedb.org/3/search/multi?api_key=1865f43a0549ca50d341dd9ab8b29f49&query=" + CodecsKt.encodeURLParameter$default(StringsKt.trim(title).toString(), false, 1, (Object) null);
                Requests app = MainActivityKt.getApp();
                c00171.L$0 = title;
                c00171.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00171.Z$0 = isMovie;
                c00171.label = 1;
                title2 = null;
                z = false;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00171, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                title3 = title;
                isMovie2 = isMovie;
                break;
            case 1:
                isMovie2 = c00171.Z$0;
                String title4 = (String) c00171.L$0;
                ResultKt.throwOnFailure($result);
                z = false;
                title3 = title4;
                title2 = null;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JSONObject json = new JSONObject(((NiceResponse) $result).getText());
        JSONArray results = json.optJSONArray("results");
        if (results == null) {
            return title2;
        }
        String targetType = isMovie2 ? "movie" : "tv";
        String inputNorm = fetchtmdb$normalize(title3);
        Integer fallback = null;
        int i = 0;
        int length = results.length();
        while (i < length) {
            JSONObject item = results.optJSONObject(i);
            if (item == null) {
                str = title2;
            } else if (Intrinsics.areEqual(item.optString("media_type"), targetType)) {
                String resultTitle = item.optString(isMovie2 ? "title" : "name");
                String resultNorm = fetchtmdb$normalize(resultTitle);
                if (resultNorm.length() == 0) {
                    str = title2;
                } else {
                    if (fallback == null) {
                        fallback = Boxing.boxInt(item.optInt("id"));
                    }
                    if (Intrinsics.areEqual(resultNorm, inputNorm)) {
                        return Boxing.boxInt(item.optInt("id"));
                    }
                    str = null;
                    if (StringsKt.contains$default(resultNorm, inputNorm, z, 2, (Object) null) || StringsKt.contains$default(inputNorm, resultNorm, z, 2, (Object) null)) {
                        return Boxing.boxInt(item.optInt("id"));
                    }
                }
            } else {
                str = title2;
            }
            i++;
            title3 = title3;
            results = results;
            title2 = str;
            isMovie2 = isMovie2;
        }
        return fallback;
    }

    private static final String fetchtmdb$normalize(String s) {
        String string;
        if (s == null) {
            return "";
        }
        String lowerCase = s.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (lowerCase != null) {
            String strReplace = new Regex("[^a-z0-9]").replace(lowerCase, "");
            return (strReplace == null || (string = StringsKt.trim(strReplace).toString()) == null) ? "" : string;
        }
        return "";
    }

    @NotNull
    public static final List<ActorData> parseCredits(@Nullable String jsonText) {
        String str = jsonText;
        if (str == null || StringsKt.isBlank(str)) {
            return CollectionsKt.emptyList();
        }
        ArrayList list = new ArrayList();
        JSONObject root = new JSONObject(jsonText);
        JSONArray castArr = root.optJSONArray("cast");
        if (castArr == null) {
            return list;
        }
        int length = castArr.length();
        for (int i = 0; i < length; i++) {
            JSONObject c = castArr.optJSONObject(i);
            if (c != null) {
                String name = c.optString("name");
                if (StringsKt.isBlank(name)) {
                    name = null;
                }
                if (name == null && (name = c.optString("original_name")) == null) {
                    name = "";
                }
                String it = c.optString("profile_path");
                if (StringsKt.isBlank(it)) {
                    it = null;
                }
                String it2 = it != null ? FourKHDHub.TMDBIMAGEBASEURL + it : null;
                String it3 = c.optString("character");
                String character = StringsKt.isBlank(it3) ? null : it3;
                Actor actor = new Actor(name, it2);
                list.add(new ActorData(actor, (ActorRole) null, character, (Actor) null, 10, (DefaultConstructorMarker) null));
            }
        }
        return list;
    }

    @NotNull
    public static final SearchQuality getSearchQuality(@NotNull List<String> list) {
        if (list.isEmpty()) {
            return SearchQuality.HD;
        }
        String text = Normalizer.normalize(CollectionsKt.joinToString$default(list, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), Normalizer.Form.NFKC).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(text, "toLowerCase(...)");
        List<Pair> patterns = CollectionsKt.listOf(new Pair[]{TuplesKt.to(new Regex("\\b(4k|ds4k|uhd|2160p)\\b"), SearchQuality.FourK), TuplesKt.to(new Regex("\\b(1440p|qhd)\\b"), SearchQuality.BlueRay), TuplesKt.to(new Regex("\\b(bluray|bdrip|blu[- ]?ray)\\b"), SearchQuality.BlueRay), TuplesKt.to(new Regex("\\b(1080p|fullhd)\\b"), SearchQuality.HD), TuplesKt.to(new Regex("\\b(720p)\\b"), SearchQuality.SD), TuplesKt.to(new Regex("\\b(web[- ]?dl|webrip|webdl)\\b"), SearchQuality.WebRip), TuplesKt.to(new Regex("\\b(hdrip|hdtv)\\b"), SearchQuality.HD), TuplesKt.to(new Regex("\\b(camrip|cam[- ]?rip)\\b"), SearchQuality.CamRip), TuplesKt.to(new Regex("\\b(hdts|hdcam|hdtc)\\b"), SearchQuality.HdCam), TuplesKt.to(new Regex("\\b(cam)\\b"), SearchQuality.Cam), TuplesKt.to(new Regex("\\b(dvd)\\b"), SearchQuality.DVD), TuplesKt.to(new Regex("\\b(hq)\\b"), SearchQuality.HQ), TuplesKt.to(new Regex("\\b(rip)\\b"), SearchQuality.CamRip)});
        for (Pair pair : patterns) {
            Regex regex = (Regex) pair.component1();
            SearchQuality quality = (SearchQuality) pair.component2();
            if (regex.containsMatchIn(text)) {
                return quality;
            }
        }
        return SearchQuality.HD;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public static final Object loadSourceNameExtractor(@NotNull final String source, @NotNull String url, @Nullable String referer, @Nullable final Integer quality, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull final Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00191 c00191;
        if (continuation instanceof C00191) {
            c00191 = (C00191) continuation;
            if ((c00191.label & Integer.MIN_VALUE) != 0) {
                c00191.label -= Integer.MIN_VALUE;
            } else {
                c00191 = new C00191(continuation);
            }
        } else {
            c00191 = new C00191(continuation);
        }
        Object $result = c00191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00191.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1 function3 = new Function1() { // from class: com.fourKHDHub.UtilsKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return UtilsKt.loadSourceNameExtractor$lambda$0(function2, source, quality, (ExtractorLink) obj);
                    }
                };
                c00191.L$0 = SpillingKt.nullOutSpilledVariable(source);
                c00191.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00191.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00191.L$3 = SpillingKt.nullOutSpilledVariable(quality);
                c00191.L$4 = SpillingKt.nullOutSpilledVariable(function1);
                c00191.L$5 = SpillingKt.nullOutSpilledVariable(function2);
                c00191.label = 1;
                if (ExtractorApiKt.loadExtractor(url, referer, function1, function3, c00191) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object loadSourceNameExtractor$default(String str, String str2, String str3, Integer num, Function1 function1, Function1 function2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        return loadSourceNameExtractor(str, str2, str3, num, function1, function2, continuation);
    }

    static final Unit loadSourceNameExtractor$lambda$0(Function1 $callback, String $source, Integer $quality, ExtractorLink link) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new UtilsKt$loadSourceNameExtractor$2$1($callback, link, $source, $quality, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Score safeScoreFrom10(@Nullable Double value) {
        if (value != null) {
            double it = value.doubleValue();
            Double d = !Double.isNaN(it) && (it > 0.0d ? 1 : (it == 0.0d ? 0 : -1)) > 0 ? value : null;
            if (d == null) {
                return null;
            }
            return Score.Companion.from10(Double.valueOf(d.doubleValue()));
        }
        return null;
    }
}
