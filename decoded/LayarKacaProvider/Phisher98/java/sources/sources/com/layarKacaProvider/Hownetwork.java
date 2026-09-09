package com.layarKacaProvider;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/LayarKacaProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/layarKacaProvider/Hownetwork;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LayarKacaProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/layarKacaProvider/Hownetwork\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,326:1\n1#2:327\n2068#3,2:328\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/layarKacaProvider/Hownetwork\n*L\n64#1:328,2\n*E\n"})
public class Hownetwork extends ExtractorApi {

    @NotNull
    private final String name = "Hownetwork";

    @NotNull
    private final String mainUrl = "https://stream.hownetwork.xyz";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.layarKacaProvider.Hownetwork$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.layarKacaProvider.Hownetwork", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {41, 60, 67}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "id", "$this$getUrl_u24lambda_u240", "$this", "url", "referer", "subtitleCallback", "callback", "id", "response", "json", "file", "$this", "url", "referer", "subtitleCallback", "callback", "id", "response", "json", "file"}, nl = {52, 64, 66}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
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

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Hownetwork.getUrl$suspendImpl(Hownetwork.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
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

    /* JADX WARN: Code duplicated, block: B:46:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:49:0x0204  */
    /* JADX WARN: Code duplicated, block: B:51:0x0207  */
    /* JADX WARN: Code duplicated, block: B:58:0x0228  */
    /* JADX WARN: Code duplicated, block: B:61:0x022d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0230  */
    /* JADX WARN: Code duplicated, block: B:65:0x0240  */
    /* JADX WARN: Code duplicated, block: B:67:0x0257  */
    /* JADX WARN: Code duplicated, block: B:69:0x0263  */
    /* JADX WARN: Code duplicated, block: B:70:0x0265  */
    /* JADX WARN: Code duplicated, block: B:73:0x02b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:78:0x02cd A[LOOP:0: B:76:0x02c7->B:78:0x02cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:80:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:82:0x033d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:83:0x033e  */
    /* JADX WARN: Code duplicated, block: B:85:0x0359  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 8 */
    static /* synthetic */ Object getUrl$suspendImpl(Hownetwork $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00011 c00011;
        Object obj;
        Hownetwork $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String id;
        Object obj2;
        Object obj3;
        Hownetwork $this3;
        String id2;
        Function1<? super SubtitleFile, Unit> function5;
        String id3;
        String url3;
        String response;
        Object obj4;
        Object obj5;
        JSONObject json;
        String file;
        Object obj6;
        Hownetwork $this4;
        JSONObject json2;
        String file2;
        String referer3;
        Function1<? super ExtractorLink, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
        String url4;
        String id4;
        Function1<? super SubtitleFile, Unit> function8;
        String response2;
        Object obj7;
        String str;
        Hownetwork $this5;
        JSONObject json3;
        String file3;
        String referer4;
        Function1<? super ExtractorLink, Unit> function9;
        String url5;
        String id5;
        Function1<? super SubtitleFile, Unit> function10;
        String response3;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = $this.new C00011(continuation);
            }
        } else {
            c00011 = $this.new C00011(continuation);
        }
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String id6 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(url, "id=", (String) null, 2, (Object) null), "&", (String) null, 2, (Object) null);
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    String str2 = $this.getMainUrl() + "/api.php?id=" + id6;
                    Pair[] pairArr = new Pair[2];
                    pairArr[0] = TuplesKt.to("r", referer == null ? "" : referer);
                    pairArr[1] = TuplesKt.to("d", $this.getMainUrl());
                    Map mapMapOf = MapsKt.mapOf(pairArr);
                    Map mapMapOf2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Requested-With", "XMLHttpRequest"), TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")});
                    c00012.L$0 = $this;
                    c00012.L$1 = url;
                    c00012.L$2 = referer;
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                    c00012.L$4 = function2;
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(id6);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable($this);
                    c00012.label = 1;
                    obj = coroutine_suspended;
                    try {
                        $result = Requests.post$default(app, str2, mapMapOf2, url, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 65496, (Object) null);
                        c00012 = c00012;
                        if ($result == obj) {
                            return obj;
                        }
                        $this2 = $this;
                        url2 = url;
                        referer2 = referer;
                        function3 = function1;
                        function4 = function2;
                        id = id6;
                        try {
                            obj2 = Result.constructor-impl(((NiceResponse) $result).getText());
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Object $result2 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        obj3 = obj2;
                        $this3 = $this2;
                        id2 = id;
                        function5 = function3;
                        id3 = referer2;
                        url3 = url2;
                        if (Result.isFailure-impl(obj3)) {
                            obj3 = null;
                        }
                        response = (String) obj3;
                        if (response == null) {
                            return Unit.INSTANCE;
                        }
                        try {
                            Result.Companion companion2 = Result.Companion;
                            obj4 = Result.constructor-impl(new JSONObject(response));
                            break;
                        } catch (Throwable th2) {
                            Result.Companion companion3 = Result.Companion;
                            obj4 = Result.constructor-impl(ResultKt.createFailure(th2));
                        }
                        obj5 = obj4;
                        if (Result.isFailure-impl(obj5)) {
                            obj5 = null;
                        }
                        json = (JSONObject) obj5;
                        if (json == null) {
                            return Unit.INSTANCE;
                        }
                        file = json.optString("file");
                        if (!StringsKt.isBlank(file)) {
                            Log.INSTANCE.d("Hownetwork", file);
                            if (StringsKt.contains$default(file, ".m3u8", false, 2, (Object) null)) {
                                obj7 = obj;
                                M3u8Helper.Companion companion4 = M3u8Helper.Companion;
                                String response4 = $this3.getName();
                                if (id3 == null) {
                                    str = url3;
                                } else {
                                    str = id3;
                                }
                                c00012.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                                c00012.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                                c00012.L$4 = function4;
                                c00012.L$5 = SpillingKt.nullOutSpilledVariable(id2);
                                c00012.L$6 = SpillingKt.nullOutSpilledVariable(response);
                                c00012.L$7 = SpillingKt.nullOutSpilledVariable(json);
                                c00012.L$8 = SpillingKt.nullOutSpilledVariable(file);
                                c00012.label = 2;
                                C00011 c00013 = c00012;
                                $result = M3u8Helper.Companion.generateM3u8$default(companion4, response4, file, str, (Integer) null, (Map) null, (String) null, c00013, 56, (Object) null);
                                c00012 = c00013;
                                if ($result == obj7) {
                                    return obj7;
                                }
                                $this5 = $this3;
                                json3 = json;
                                file3 = file;
                                referer4 = id3;
                                function9 = function4;
                                url5 = url3;
                                id5 = id2;
                                function10 = function5;
                                response3 = response;
                                Iterable $this$forEach$iv = (Iterable) $result;
                                for (Object element$iv : $this$forEach$iv) {
                                    function9.invoke(element$iv);
                                }
                            } else {
                                obj6 = obj;
                                String name = $this3.getName();
                                String name2 = $this3.getName();
                                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                                c00012.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                                c00012.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                                c00012.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                                c00012.L$5 = SpillingKt.nullOutSpilledVariable(id2);
                                c00012.L$6 = SpillingKt.nullOutSpilledVariable(response);
                                c00012.L$7 = SpillingKt.nullOutSpilledVariable(json);
                                c00012.L$8 = SpillingKt.nullOutSpilledVariable(file);
                                c00012.L$9 = function4;
                                c00012.label = 3;
                                $result = ExtractorApiKt.newExtractorLink$default(name, name2, file, infer_type, (Function2) null, c00012, 16, (Object) null);
                                if ($result == obj6) {
                                    return obj6;
                                }
                                $this4 = $this3;
                                json2 = json;
                                file2 = file;
                                referer3 = id3;
                                function6 = function4;
                                function7 = function6;
                                url4 = url3;
                                id4 = id2;
                                function8 = function5;
                                response2 = response;
                                function6.invoke($result);
                            }
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        c00012 = c00012;
                        $this2 = $this;
                        url2 = url;
                        referer2 = referer;
                        function3 = function1;
                        function4 = function2;
                        id = id6;
                        Object $result3 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        obj3 = obj2;
                        $this3 = $this2;
                        id2 = id;
                        function5 = function3;
                        id3 = referer2;
                        url3 = url2;
                        if (Result.isFailure-impl(obj3)) {
                            obj3 = null;
                        }
                        response = (String) obj3;
                        if (response == null) {
                            return Unit.INSTANCE;
                        }
                        Result.Companion companion5 = Result.Companion;
                        obj4 = Result.constructor-impl(new JSONObject(response));
                        obj5 = obj4;
                        if (Result.isFailure-impl(obj5)) {
                            obj5 = null;
                        }
                        json = (JSONObject) obj5;
                        if (json == null) {
                            return Unit.INSTANCE;
                        }
                        file = json.optString("file");
                        if (!StringsKt.isBlank(file)) {
                            Log.INSTANCE.d("Hownetwork", file);
                            if (StringsKt.contains$default(file, ".m3u8", false, 2, (Object) null)) {
                                obj7 = obj;
                                M3u8Helper.Companion companion6 = M3u8Helper.Companion;
                                String response5 = $this3.getName();
                                if (id3 == null) {
                                    str = url3;
                                } else {
                                    str = id3;
                                }
                                c00012.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                                c00012.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                                c00012.L$4 = function4;
                                c00012.L$5 = SpillingKt.nullOutSpilledVariable(id2);
                                c00012.L$6 = SpillingKt.nullOutSpilledVariable(response);
                                c00012.L$7 = SpillingKt.nullOutSpilledVariable(json);
                                c00012.L$8 = SpillingKt.nullOutSpilledVariable(file);
                                c00012.label = 2;
                                C00011 c00014 = c00012;
                                $result = M3u8Helper.Companion.generateM3u8$default(companion6, response5, file, str, (Integer) null, (Map) null, (String) null, c00014, 56, (Object) null);
                                c00012 = c00014;
                                if ($result == obj7) {
                                    return obj7;
                                }
                                $this5 = $this3;
                                json3 = json;
                                file3 = file;
                                referer4 = id3;
                                function9 = function4;
                                url5 = url3;
                                id5 = id2;
                                function10 = function5;
                                response3 = response;
                                Iterable $this$forEach$iv2 = (Iterable) $result;
                                while (r12.hasNext()) {
                                    function9.invoke(element$iv);
                                }
                            } else {
                                obj6 = obj;
                                String name3 = $this3.getName();
                                String name4 = $this3.getName();
                                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                                c00012.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                                c00012.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                                c00012.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                                c00012.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                                c00012.L$5 = SpillingKt.nullOutSpilledVariable(id2);
                                c00012.L$6 = SpillingKt.nullOutSpilledVariable(response);
                                c00012.L$7 = SpillingKt.nullOutSpilledVariable(json);
                                c00012.L$8 = SpillingKt.nullOutSpilledVariable(file);
                                c00012.L$9 = function4;
                                c00012.label = 3;
                                $result = ExtractorApiKt.newExtractorLink$default(name3, name4, file, infer_type2, (Function2) null, c00012, 16, (Object) null);
                                if ($result == obj6) {
                                    return obj6;
                                }
                                $this4 = $this3;
                                json2 = json;
                                file2 = file;
                                referer3 = id3;
                                function6 = function4;
                                function7 = function6;
                                url4 = url3;
                                id4 = id2;
                                function8 = function5;
                                response2 = response;
                                function6.invoke($result);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    obj = coroutine_suspended;
                    $this2 = $this;
                    url2 = url;
                    referer2 = referer;
                    function3 = function1;
                    function4 = function2;
                    id = id6;
                }
                break;
            case 1:
                id = (String) c00012.L$5;
                function4 = (Function1) c00012.L$4;
                function3 = (Function1) c00012.L$3;
                String referer5 = (String) c00012.L$2;
                url2 = (String) c00012.L$1;
                Hownetwork $this6 = (Hownetwork) c00012.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    referer2 = referer5;
                    $this2 = $this6;
                    obj = coroutine_suspended;
                    obj2 = Result.constructor-impl(((NiceResponse) $result).getText());
                    break;
                } catch (Throwable th5) {
                    th = th5;
                    referer2 = referer5;
                    $this2 = $this6;
                    obj = coroutine_suspended;
                    Object $result4 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    obj3 = obj2;
                    $this3 = $this2;
                    id2 = id;
                    function5 = function3;
                    id3 = referer2;
                    url3 = url2;
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = null;
                    }
                    response = (String) obj3;
                    if (response == null) {
                        return Unit.INSTANCE;
                    }
                    Result.Companion companion7 = Result.Companion;
                    obj4 = Result.constructor-impl(new JSONObject(response));
                    obj5 = obj4;
                    if (Result.isFailure-impl(obj5)) {
                        obj5 = null;
                    }
                    json = (JSONObject) obj5;
                    if (json == null) {
                        return Unit.INSTANCE;
                    }
                    file = json.optString("file");
                    if (!StringsKt.isBlank(file)) {
                        Log.INSTANCE.d("Hownetwork", file);
                        if (StringsKt.contains$default(file, ".m3u8", false, 2, (Object) null)) {
                            obj7 = obj;
                            M3u8Helper.Companion companion8 = M3u8Helper.Companion;
                            String response6 = $this3.getName();
                            if (id3 == null) {
                                str = url3;
                            } else {
                                str = id3;
                            }
                            c00012.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                            c00012.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                            c00012.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                            c00012.L$4 = function4;
                            c00012.L$5 = SpillingKt.nullOutSpilledVariable(id2);
                            c00012.L$6 = SpillingKt.nullOutSpilledVariable(response);
                            c00012.L$7 = SpillingKt.nullOutSpilledVariable(json);
                            c00012.L$8 = SpillingKt.nullOutSpilledVariable(file);
                            c00012.label = 2;
                            C00011 c00015 = c00012;
                            $result = M3u8Helper.Companion.generateM3u8$default(companion8, response6, file, str, (Integer) null, (Map) null, (String) null, c00015, 56, (Object) null);
                            c00012 = c00015;
                            if ($result == obj7) {
                                return obj7;
                            }
                            $this5 = $this3;
                            json3 = json;
                            file3 = file;
                            referer4 = id3;
                            function9 = function4;
                            url5 = url3;
                            id5 = id2;
                            function10 = function5;
                            response3 = response;
                            Iterable $this$forEach$iv3 = (Iterable) $result;
                            while (r12.hasNext()) {
                                function9.invoke(element$iv);
                            }
                        } else {
                            obj6 = obj;
                            String name5 = $this3.getName();
                            String name6 = $this3.getName();
                            ExtractorLinkType infer_type3 = ExtractorApiKt.getINFER_TYPE();
                            c00012.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                            c00012.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                            c00012.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                            c00012.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                            c00012.L$5 = SpillingKt.nullOutSpilledVariable(id2);
                            c00012.L$6 = SpillingKt.nullOutSpilledVariable(response);
                            c00012.L$7 = SpillingKt.nullOutSpilledVariable(json);
                            c00012.L$8 = SpillingKt.nullOutSpilledVariable(file);
                            c00012.L$9 = function4;
                            c00012.label = 3;
                            $result = ExtractorApiKt.newExtractorLink$default(name5, name6, file, infer_type3, (Function2) null, c00012, 16, (Object) null);
                            if ($result == obj6) {
                                return obj6;
                            }
                            $this4 = $this3;
                            json2 = json;
                            file2 = file;
                            referer3 = id3;
                            function6 = function4;
                            function7 = function6;
                            url4 = url3;
                            id4 = id2;
                            function8 = function5;
                            response2 = response;
                            function6.invoke($result);
                        }
                    }
                    return Unit.INSTANCE;
                }
                obj3 = obj2;
                $this3 = $this2;
                id2 = id;
                function5 = function3;
                id3 = referer2;
                url3 = url2;
                if (Result.isFailure-impl(obj3)) {
                    obj3 = null;
                }
                response = (String) obj3;
                if (response == null) {
                    return Unit.INSTANCE;
                }
                Result.Companion companion9 = Result.Companion;
                obj4 = Result.constructor-impl(new JSONObject(response));
                obj5 = obj4;
                if (Result.isFailure-impl(obj5)) {
                    obj5 = null;
                }
                json = (JSONObject) obj5;
                if (json == null) {
                    return Unit.INSTANCE;
                }
                file = json.optString("file");
                if (!StringsKt.isBlank(file)) {
                    Log.INSTANCE.d("Hownetwork", file);
                    if (StringsKt.contains$default(file, ".m3u8", false, 2, (Object) null)) {
                        obj7 = obj;
                        M3u8Helper.Companion companion10 = M3u8Helper.Companion;
                        String response7 = $this3.getName();
                        if (id3 == null) {
                            str = url3;
                        } else {
                            str = id3;
                        }
                        c00012.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                        c00012.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                        c00012.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                        c00012.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                        c00012.L$4 = function4;
                        c00012.L$5 = SpillingKt.nullOutSpilledVariable(id2);
                        c00012.L$6 = SpillingKt.nullOutSpilledVariable(response);
                        c00012.L$7 = SpillingKt.nullOutSpilledVariable(json);
                        c00012.L$8 = SpillingKt.nullOutSpilledVariable(file);
                        c00012.label = 2;
                        C00011 c00016 = c00012;
                        $result = M3u8Helper.Companion.generateM3u8$default(companion10, response7, file, str, (Integer) null, (Map) null, (String) null, c00016, 56, (Object) null);
                        c00012 = c00016;
                        if ($result == obj7) {
                            return obj7;
                        }
                        $this5 = $this3;
                        json3 = json;
                        file3 = file;
                        referer4 = id3;
                        function9 = function4;
                        url5 = url3;
                        id5 = id2;
                        function10 = function5;
                        response3 = response;
                        Iterable $this$forEach$iv4 = (Iterable) $result;
                        while (r12.hasNext()) {
                            function9.invoke(element$iv);
                        }
                    } else {
                        obj6 = obj;
                        String name7 = $this3.getName();
                        String name8 = $this3.getName();
                        ExtractorLinkType infer_type4 = ExtractorApiKt.getINFER_TYPE();
                        c00012.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                        c00012.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                        c00012.L$2 = SpillingKt.nullOutSpilledVariable(id3);
                        c00012.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                        c00012.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                        c00012.L$5 = SpillingKt.nullOutSpilledVariable(id2);
                        c00012.L$6 = SpillingKt.nullOutSpilledVariable(response);
                        c00012.L$7 = SpillingKt.nullOutSpilledVariable(json);
                        c00012.L$8 = SpillingKt.nullOutSpilledVariable(file);
                        c00012.L$9 = function4;
                        c00012.label = 3;
                        $result = ExtractorApiKt.newExtractorLink$default(name7, name8, file, infer_type4, (Function2) null, c00012, 16, (Object) null);
                        if ($result == obj6) {
                            return obj6;
                        }
                        $this4 = $this3;
                        json2 = json;
                        file2 = file;
                        referer3 = id3;
                        function6 = function4;
                        function7 = function6;
                        url4 = url3;
                        id4 = id2;
                        function8 = function5;
                        response2 = response;
                        function6.invoke($result);
                    }
                }
                return Unit.INSTANCE;
            case 2:
                file3 = (String) c00012.L$8;
                json3 = (JSONObject) c00012.L$7;
                response3 = (String) c00012.L$6;
                id5 = (String) c00012.L$5;
                function9 = (Function1) c00012.L$4;
                function10 = (Function1) c00012.L$3;
                referer4 = (String) c00012.L$2;
                url5 = (String) c00012.L$1;
                $this5 = (Hownetwork) c00012.L$0;
                ResultKt.throwOnFailure($result);
                Iterable $this$forEach$iv5 = (Iterable) $result;
                while (r12.hasNext()) {
                    function9.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 3:
                function6 = (Function1) c00012.L$9;
                file2 = (String) c00012.L$8;
                json2 = (JSONObject) c00012.L$7;
                response2 = (String) c00012.L$6;
                id4 = (String) c00012.L$5;
                function7 = (Function1) c00012.L$4;
                function8 = (Function1) c00012.L$3;
                referer3 = (String) c00012.L$2;
                url4 = (String) c00012.L$1;
                $this4 = (Hownetwork) c00012.L$0;
                ResultKt.throwOnFailure($result);
                function6.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
