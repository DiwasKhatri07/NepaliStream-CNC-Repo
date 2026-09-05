package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/phisher98/HDm2;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeUrl", "raw", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/HDm2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n1#2:4004\n2068#3,2:4005\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/HDm2\n*L\n2946#1:4005,2\n*E\n"})
public final class HDm2 extends ExtractorApi {

    @NotNull
    private final String name = "Ultra Stream V3";

    @NotNull
    private final String mainUrl = "https://hdm2.ink";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.HDm2$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.HDm2", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {2927, 2946}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "headers", "url", "referer", "subtitleCallback", "callback", "headers", "res", "regex", "args", "baseUrl", "m3u8", "safe"}, nl = {2928, 4005}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    static final class C00311 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00311(Continuation<? super C00311> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HDm2.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0114  */
    /* JADX WARN: Code duplicated, block: B:32:0x0124  */
    /* JADX WARN: Code duplicated, block: B:40:0x016d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0186 A[Catch: all -> 0x01e8, TRY_ENTER, TryCatch #0 {all -> 0x01e8, blocks: (B:44:0x017e, B:47:0x0186, B:49:0x01e2, B:48:0x01ba), top: B:71:0x017e }] */
    /* JADX WARN: Code duplicated, block: B:48:0x01ba A[Catch: all -> 0x01e8, TryCatch #0 {all -> 0x01e8, blocks: (B:44:0x017e, B:47:0x0186, B:49:0x01e2, B:48:0x01ba), top: B:71:0x017e }] */
    /* JADX WARN: Code duplicated, block: B:58:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:61:0x0263 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x0264  */
    /* JADX WARN: Code duplicated, block: B:66:0x0282 A[LOOP:0: B:64:0x027c->B:66:0x0282, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x029b  */
    /* JADX WARN: Code duplicated, block: B:73:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00311 c00311;
        Object obj;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        Map headers;
        Function1<? super ExtractorLink, Unit> function4;
        String res;
        Regex regex;
        MatchResult matchResultFind$default;
        String string;
        String args;
        String str;
        boolean z;
        Object obj3;
        String mainUrl;
        String baseUrl;
        Regex regex2;
        Object obj4;
        String safe;
        Function1<? super ExtractorLink, Unit> function5;
        Regex regex3;
        String referer3;
        String url3;
        String m3u8;
        Map headers2;
        Function1<? super SubtitleFile, Unit> function6;
        String res2;
        Function1<? super ExtractorLink, Unit> function7;
        Regex regex4;
        String baseUrl2;
        String str2;
        List groupValues;
        String str3;
        if (continuation instanceof C00311) {
            c00311 = (C00311) continuation;
            if ((c00311.label & Integer.MIN_VALUE) != 0) {
                c00311.label -= Integer.MIN_VALUE;
            } else {
                c00311 = new C00311(continuation);
            }
        } else {
            c00311 = new C00311(continuation);
        }
        C00311 c00312 = c00311;
        Object $result = c00312.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00312.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Map headers3 = MapsKt.mapOf(TuplesKt.to("user-agent", "okhttp/4.12.0"));
                Requests app = MainActivityKt.getApp();
                c00312.L$0 = url;
                c00312.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c00312.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00312.L$3 = function2;
                c00312.L$4 = headers3;
                c00312.label = 1;
                obj = coroutine_suspended;
                Object obj5 = Requests.get$default(app, url, headers3, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00312, 4088, (Object) null);
                c00312 = c00312;
                if (obj5 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                obj2 = obj5;
                headers = headers3;
                function4 = function2;
                res = ((NiceResponse) obj2).getText();
                regex = new Regex("data-stream-url=[\"'](.*?)[\"']");
                matchResultFind$default = Regex.find$default(regex, res, 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str3 = (String) groupValues.get(1)) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(str3).toString();
                }
                args = string;
                str = args;
                if (str != null || str.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    try {
                        Result.Companion companion = Result.Companion;
                        HDm2 hDm2 = this;
                        URI it = new URI(url2);
                        obj3 = Result.constructor-impl(it.getScheme() + "://" + it.getAuthority());
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    mainUrl = getMainUrl();
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = mainUrl;
                    }
                    baseUrl = (String) obj3;
                    try {
                        Result.Companion companion3 = Result.Companion;
                        HDm2 hDm3 = this;
                        regex2 = regex;
                        try {
                            if (StringsKt.startsWith$default(args, "http", false, 2, (Object) null)) {
                                String file = new URL(args).getFile();
                                str2 = StringsKt.trimEnd(baseUrl, new char[]{'/'}) + '/' + StringsKt.removePrefix(file, "/");
                            } else {
                                str2 = StringsKt.trimEnd(baseUrl, new char[]{'/'}) + '/' + StringsKt.removePrefix(args, "/");
                            }
                            obj4 = Result.constructor-impl(str2);
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion4 = Result.Companion;
                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        regex2 = regex;
                    }
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = args;
                    }
                    String m3u9 = (String) obj4;
                    safe = safeUrl(m3u9);
                    M3u8Helper.Companion companion5 = M3u8Helper.Companion;
                    String name = getName();
                    c00312.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00312.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00312.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00312.L$3 = function4;
                    c00312.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                    c00312.L$5 = SpillingKt.nullOutSpilledVariable(res);
                    c00312.L$6 = SpillingKt.nullOutSpilledVariable(regex2);
                    c00312.L$7 = SpillingKt.nullOutSpilledVariable(args);
                    c00312.L$8 = SpillingKt.nullOutSpilledVariable(baseUrl);
                    c00312.L$9 = SpillingKt.nullOutSpilledVariable(m3u9);
                    c00312.L$10 = SpillingKt.nullOutSpilledVariable(safe);
                    c00312.label = 2;
                    function5 = function4;
                    regex3 = regex2;
                    $result = M3u8Helper.Companion.generateM3u8$default(companion5, name, safe, baseUrl, (Integer) null, headers, (String) null, c00312, 40, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    String str4 = referer2;
                    referer3 = url2;
                    url3 = str4;
                    m3u8 = safe;
                    headers2 = headers;
                    function6 = function3;
                    res2 = res;
                    function7 = function5;
                    regex4 = regex3;
                    baseUrl2 = args;
                    Iterable $this$forEach$iv = (Iterable) $result;
                    for (Object element$iv : $this$forEach$iv) {
                        String safe2 = m3u8;
                        function7.invoke(element$iv);
                        m3u8 = safe2;
                    }
                    break;
                } else {
                    Log.INSTANCE.w("HDm2", "stream url not found");
                }
                return Unit.INSTANCE;
            case 1:
                Map headers4 = (Map) c00312.L$4;
                Function1<? super ExtractorLink, Unit> function8 = (Function1) c00312.L$3;
                Function1<? super SubtitleFile, Unit> function9 = (Function1) c00312.L$2;
                String referer4 = (String) c00312.L$1;
                String url4 = (String) c00312.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                function3 = function9;
                referer2 = referer4;
                url2 = url4;
                headers = headers4;
                obj2 = $result;
                function4 = function8;
                res = ((NiceResponse) obj2).getText();
                regex = new Regex("data-stream-url=[\"'](.*?)[\"']");
                matchResultFind$default = Regex.find$default(regex, res, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    string = null;
                } else {
                    string = null;
                }
                args = string;
                str = args;
                if (str != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (!z) {
                    Result.Companion companion6 = Result.Companion;
                    HDm2 hDm4 = this;
                    URI it2 = new URI(url2);
                    obj3 = Result.constructor-impl(it2.getScheme() + "://" + it2.getAuthority());
                    mainUrl = getMainUrl();
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = mainUrl;
                    }
                    baseUrl = (String) obj3;
                    Result.Companion companion7 = Result.Companion;
                    HDm2 hDm5 = this;
                    regex2 = regex;
                    if (StringsKt.startsWith$default(args, "http", false, 2, (Object) null)) {
                        String file2 = new URL(args).getFile();
                        str2 = StringsKt.trimEnd(baseUrl, new char[]{'/'}) + '/' + StringsKt.removePrefix(file2, "/");
                    } else {
                        str2 = StringsKt.trimEnd(baseUrl, new char[]{'/'}) + '/' + StringsKt.removePrefix(args, "/");
                    }
                    obj4 = Result.constructor-impl(str2);
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = args;
                    }
                    String m3u10 = (String) obj4;
                    safe = safeUrl(m3u10);
                    M3u8Helper.Companion companion8 = M3u8Helper.Companion;
                    String name2 = getName();
                    c00312.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00312.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00312.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00312.L$3 = function4;
                    c00312.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                    c00312.L$5 = SpillingKt.nullOutSpilledVariable(res);
                    c00312.L$6 = SpillingKt.nullOutSpilledVariable(regex2);
                    c00312.L$7 = SpillingKt.nullOutSpilledVariable(args);
                    c00312.L$8 = SpillingKt.nullOutSpilledVariable(baseUrl);
                    c00312.L$9 = SpillingKt.nullOutSpilledVariable(m3u10);
                    c00312.L$10 = SpillingKt.nullOutSpilledVariable(safe);
                    c00312.label = 2;
                    function5 = function4;
                    regex3 = regex2;
                    $result = M3u8Helper.Companion.generateM3u8$default(companion8, name2, safe, baseUrl, (Integer) null, headers, (String) null, c00312, 40, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    String str5 = referer2;
                    referer3 = url2;
                    url3 = str5;
                    m3u8 = safe;
                    headers2 = headers;
                    function6 = function3;
                    res2 = res;
                    function7 = function5;
                    regex4 = regex3;
                    baseUrl2 = args;
                    Iterable $this$forEach$iv2 = (Iterable) $result;
                    while (r15.hasNext()) {
                        String safe3 = m3u8;
                        function7.invoke(element$iv);
                        m3u8 = safe3;
                    }
                } else {
                    Log.INSTANCE.w("HDm2", "stream url not found");
                }
                return Unit.INSTANCE;
            case 2:
                m3u8 = (String) c00312.L$10;
                baseUrl2 = (String) c00312.L$7;
                regex4 = (Regex) c00312.L$6;
                res2 = (String) c00312.L$5;
                headers2 = (Map) c00312.L$4;
                function7 = (Function1) c00312.L$3;
                function6 = (Function1) c00312.L$2;
                url3 = (String) c00312.L$1;
                referer3 = (String) c00312.L$0;
                ResultKt.throwOnFailure($result);
                Iterable $this$forEach$iv3 = (Iterable) $result;
                while (r15.hasNext()) {
                    String safe4 = m3u8;
                    function7.invoke(element$iv);
                    m3u8 = safe4;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final String safeUrl(String raw) {
        List groupValues;
        String cleaned = StringsKt.replace$default(raw, "&amp;", "&", false, 4, (Object) null);
        String tok = null;
        String base = StringsKt.substringBefore$default(cleaned, "?", (String) null, 2, (Object) null);
        MatchResult matchResultFind$default = Regex.find$default(new Regex("[?&]tok=([^&]+)"), cleaned, 0, 2, (Object) null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
            tok = (String) groupValues.get(1);
        }
        String str = tok;
        return !(str == null || str.length() == 0) ? base + "?tok=" + tok : base;
    }
}
