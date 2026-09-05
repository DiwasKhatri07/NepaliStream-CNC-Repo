package com.Microtv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Microtv/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/Microtv/PdlkExtractor;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PdlkApiResp", "PdlkData", "Microtv"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/Microtv/PdlkExtractor\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,348:1\n93#2,2:349\n63#2:351\n64#2,15:353\n95#2,2:370\n1#3:352\n1#3:372\n50#4:368\n43#4:369\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/Microtv/PdlkExtractor\n*L\n322#1:349,2\n322#1:351\n322#1:353,15\n322#1:370,2\n322#1:352\n322#1:368\n322#1:369\n*E\n"})
public final class PdlkExtractor extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "PDLink";

    @NotNull
    private final String mainUrl = "https://pdlk.site";

    /* JADX INFO: renamed from: com.Microtv.PdlkExtractor$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Microtv.PdlkExtractor", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {316, 328, 331}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "html", "jsonStr", "resp", "target", "$this$getUrl_u24lambda_u240", "url", "referer", "subtitleCallback", "callback", "html", "jsonStr", "resp", "target", "handled"}, nl = {319, 328, 330}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PdlkExtractor.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:102:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:104:0x02f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:105:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:107:0x030b  */
    /* JADX WARN: Code duplicated, block: B:125:0x0220 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:74:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:84:0x021d  */
    /* JADX WARN: Code duplicated, block: B:88:0x025f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x0260  */
    /* JADX WARN: Code duplicated, block: B:99:0x0297  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00101 c00101;
        Object obj;
        int i;
        int i2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function4;
        String html;
        MatchResult matchResultFind$default;
        List groupValues;
        String str;
        String jsonStr;
        Object obj3;
        boolean z;
        Object objDecodeFromString;
        PdlkApiResp resp;
        PdlkData data;
        String url3;
        String target;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        String referer3;
        String url4;
        String referer4;
        PdlkApiResp resp2;
        Object objLoadExtractor;
        Object obj4;
        Object obj5;
        Object obj6;
        String url5;
        String url6;
        PdlkApiResp resp3;
        Boolean boolBoxBoolean;
        boolean handled;
        PdlkApiResp resp4;
        String jsonStr2;
        String html2;
        Function1<? super ExtractorLink, Unit> function7;
        Function1<? super ExtractorLink, Unit> function8;
        Function1<? super SubtitleFile, Unit> function9;
        String html3;
        String url7;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = new C00101(continuation);
            }
        } else {
            c00101 = new C00101(continuation);
        }
        C00101 c00102 = c00101;
        Object $result = c00102.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00102.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00102.L$0 = url;
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c00102.L$2 = function1;
                c00102.L$3 = function2;
                c00102.label = 1;
                obj = coroutine_suspended;
                i = 0;
                i2 = 1;
                Object obj7 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, true, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00102, 4062, (Object) null);
                c00102 = c00102;
                if (obj7 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                obj2 = obj7;
                function4 = function2;
                html = ((NiceResponse) obj2).getText();
                matchResultFind$default = Regex.find$default(new Regex("const\\s+apiResp\\s*=\\s*(\\{.*?\\});\\s*\\n", RegexOption.DOT_MATCHES_ALL), html, i, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = (String) groupValues.get(i2)) == null) {
                    return Unit.INSTANCE;
                }
                jsonStr = str;
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(PdlkApiResp.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        break;
                    } catch (Exception e) {
                        z = false;
                        objDecodeFromString = null;
                        resp = (PdlkApiResp) objDecodeFromString;
                        if (resp == null) {
                            return Unit.INSTANCE;
                        }
                        data = resp.getData();
                        return data == null ? Unit.INSTANCE : Unit.INSTANCE;
                        target = url3;
                        if (StringsKt.isBlank(target)) {
                            return Unit.INSTANCE;
                        }
                        try {
                            Result.Companion companion2 = Result.Companion;
                            PdlkExtractor $this$getUrl_u24lambda_u240 = this;
                            c00102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            c00102.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                            c00102.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                            c00102.L$3 = function4;
                            c00102.L$4 = SpillingKt.nullOutSpilledVariable(html);
                            c00102.L$5 = SpillingKt.nullOutSpilledVariable(jsonStr);
                            c00102.L$6 = SpillingKt.nullOutSpilledVariable(resp);
                            c00102.L$7 = target;
                            c00102.L$8 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u240);
                            c00102.label = 2;
                            objLoadExtractor = ExtractorApiKt.loadExtractor(target, url2, function3, function4, c00102);
                            if (objLoadExtractor == obj) {
                                return obj;
                            }
                            function5 = function4;
                            $result = objLoadExtractor;
                            function6 = function3;
                            referer3 = referer2;
                            url4 = url2;
                            referer4 = target;
                            resp2 = resp;
                            try {
                                obj6 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) $result).booleanValue()));
                                break;
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion3 = Result.Companion;
                                obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            url5 = url4;
                            url6 = referer4;
                            resp3 = resp2;
                            boolBoxBoolean = Boxing.boxBoolean(z);
                            if (Result.isFailure-impl(obj6)) {
                                obj6 = boolBoxBoolean;
                            }
                            handled = ((Boolean) obj6).booleanValue();
                            if (!handled) {
                                String name = getName();
                                String name2 = getName();
                                C00112 c00112 = new C00112(null);
                                c00102.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                c00102.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                c00102.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                                c00102.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                                c00102.L$4 = SpillingKt.nullOutSpilledVariable(html);
                                c00102.L$5 = SpillingKt.nullOutSpilledVariable(jsonStr);
                                c00102.L$6 = SpillingKt.nullOutSpilledVariable(resp3);
                                c00102.L$7 = SpillingKt.nullOutSpilledVariable(url6);
                                c00102.L$8 = function5;
                                c00102.Z$0 = handled;
                                c00102.label = 3;
                                $result = ExtractorApiKt.newExtractorLink$default(name, name2, url6, (ExtractorLinkType) null, c00112, c00102, 8, (Object) null);
                                if ($result == obj) {
                                    return obj;
                                }
                                resp4 = resp3;
                                jsonStr2 = jsonStr;
                                html2 = html;
                                function7 = function5;
                                function8 = function7;
                                function9 = function6;
                                html3 = referer3;
                                url7 = url5;
                                function7.invoke($result);
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            function5 = function4;
                            function6 = function3;
                            referer3 = referer2;
                            url4 = url2;
                            referer4 = target;
                            resp2 = resp;
                            Result.Companion companion4 = Result.Companion;
                            obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                            url5 = url4;
                            url6 = referer4;
                            resp3 = resp2;
                            boolBoxBoolean = Boxing.boxBoolean(z);
                            if (Result.isFailure-impl(obj6)) {
                                obj6 = boolBoxBoolean;
                            }
                            handled = ((Boolean) obj6).booleanValue();
                            if (!handled) {
                                String name3 = getName();
                                String name4 = getName();
                                C00112 c00113 = new C00112(null);
                                c00102.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                c00102.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                c00102.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                                c00102.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                                c00102.L$4 = SpillingKt.nullOutSpilledVariable(html);
                                c00102.L$5 = SpillingKt.nullOutSpilledVariable(jsonStr);
                                c00102.L$6 = SpillingKt.nullOutSpilledVariable(resp3);
                                c00102.L$7 = SpillingKt.nullOutSpilledVariable(url6);
                                c00102.L$8 = function5;
                                c00102.Z$0 = handled;
                                c00102.label = 3;
                                $result = ExtractorApiKt.newExtractorLink$default(name3, name4, url6, (ExtractorLinkType) null, c00113, c00102, 8, (Object) null);
                                if ($result == obj) {
                                    return obj;
                                }
                                resp4 = resp3;
                                jsonStr2 = jsonStr;
                                html2 = html;
                                function7 = function5;
                                function8 = function7;
                                function9 = function6;
                                html3 = referer3;
                                url7 = url5;
                                function7.invoke($result);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                } catch (Throwable th3) {
                    Result.Companion companion5 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th3));
                }
                if (Result.exceptionOrNull-impl(obj3) == null) {
                    z = false;
                    obj5 = obj3;
                } else {
                    try {
                        Result.Companion companion6 = Result.Companion;
                        z = false;
                        try {
                            try {
                                obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PdlkApiResp.class), (List) null, 2, (Object) null));
                                break;
                            } catch (Throwable th4) {
                                th = th4;
                                try {
                                    Result.Companion companion7 = Result.Companion;
                                    obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e2) {
                                    objDecodeFromString = null;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        z = false;
                    }
                    obj5 = obj4;
                }
                if (Result.isFailure-impl(obj5)) {
                    obj5 = null;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj5;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, jsonStr);
                    } catch (SerializationException e3) {
                        ArchComponentExtKt.logError(e3);
                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv.readValue(jsonStr, new TypeReference<PdlkApiResp>() { // from class: com.Microtv.PdlkExtractor$getUrl$$inlined$tryParseJson$1
                        });
                    } catch (Throwable th7) {
                        ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(jsonStr, new TypeReference<PdlkApiResp>() { // from class: com.Microtv.PdlkExtractor$getUrl$$inlined$tryParseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(jsonStr, new TypeReference<PdlkApiResp>() { // from class: com.Microtv.PdlkExtractor$getUrl$$inlined$tryParseJson$1
                    });
                }
                resp = (PdlkApiResp) objDecodeFromString;
                if (resp == null) {
                    return Unit.INSTANCE;
                }
                data = resp.getData();
                if ((data == null && (url3 = data.getUrl()) != null) || (url3 = resp.getUrl()) != null) {
                    target = url3;
                    if (StringsKt.isBlank(target)) {
                        return Unit.INSTANCE;
                    }
                    Result.Companion companion8 = Result.Companion;
                    PdlkExtractor $this$getUrl_u24lambda_u241 = this;
                    c00102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00102.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00102.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00102.L$3 = function4;
                    c00102.L$4 = SpillingKt.nullOutSpilledVariable(html);
                    c00102.L$5 = SpillingKt.nullOutSpilledVariable(jsonStr);
                    c00102.L$6 = SpillingKt.nullOutSpilledVariable(resp);
                    c00102.L$7 = target;
                    c00102.L$8 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u241);
                    c00102.label = 2;
                    objLoadExtractor = ExtractorApiKt.loadExtractor(target, url2, function3, function4, c00102);
                    if (objLoadExtractor == obj) {
                        return obj;
                    }
                    function5 = function4;
                    $result = objLoadExtractor;
                    function6 = function3;
                    referer3 = referer2;
                    url4 = url2;
                    referer4 = target;
                    resp2 = resp;
                    obj6 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) $result).booleanValue()));
                    url5 = url4;
                    url6 = referer4;
                    resp3 = resp2;
                    boolBoxBoolean = Boxing.boxBoolean(z);
                    if (Result.isFailure-impl(obj6)) {
                        obj6 = boolBoxBoolean;
                    }
                    handled = ((Boolean) obj6).booleanValue();
                    if (!handled) {
                        String name5 = getName();
                        String name6 = getName();
                        C00112 c00114 = new C00112(null);
                        c00102.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                        c00102.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                        c00102.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                        c00102.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                        c00102.L$4 = SpillingKt.nullOutSpilledVariable(html);
                        c00102.L$5 = SpillingKt.nullOutSpilledVariable(jsonStr);
                        c00102.L$6 = SpillingKt.nullOutSpilledVariable(resp3);
                        c00102.L$7 = SpillingKt.nullOutSpilledVariable(url6);
                        c00102.L$8 = function5;
                        c00102.Z$0 = handled;
                        c00102.label = 3;
                        $result = ExtractorApiKt.newExtractorLink$default(name5, name6, url6, (ExtractorLinkType) null, c00114, c00102, 8, (Object) null);
                        if ($result == obj) {
                            return obj;
                        }
                        resp4 = resp3;
                        jsonStr2 = jsonStr;
                        html2 = html;
                        function7 = function5;
                        function8 = function7;
                        function9 = function6;
                        html3 = referer3;
                        url7 = url5;
                        function7.invoke($result);
                    }
                    return Unit.INSTANCE;
                }
            case 1:
                Function1<? super ExtractorLink, Unit> function10 = (Function1) c00102.L$3;
                function3 = (Function1) c00102.L$2;
                referer2 = (String) c00102.L$1;
                url2 = (String) c00102.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                i = 0;
                function4 = function10;
                obj2 = $result;
                i2 = 1;
                html = ((NiceResponse) obj2).getText();
                matchResultFind$default = Regex.find$default(new Regex("const\\s+apiResp\\s*=\\s*(\\{.*?\\});\\s*\\n", RegexOption.DOT_MATCHES_ALL), html, i, 2, (Object) null);
                if (matchResultFind$default != null) {
                }
                return Unit.INSTANCE;
            case 2:
                referer4 = (String) c00102.L$7;
                resp2 = (PdlkApiResp) c00102.L$6;
                jsonStr = (String) c00102.L$5;
                html = (String) c00102.L$4;
                function5 = (Function1) c00102.L$3;
                function6 = (Function1) c00102.L$2;
                referer3 = (String) c00102.L$1;
                url4 = (String) c00102.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = coroutine_suspended;
                    z = false;
                    obj6 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) $result).booleanValue()));
                    break;
                } catch (Throwable th8) {
                    th = th8;
                    obj = coroutine_suspended;
                    z = false;
                    Result.Companion companion9 = Result.Companion;
                    obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                    url5 = url4;
                    url6 = referer4;
                    resp3 = resp2;
                    boolBoxBoolean = Boxing.boxBoolean(z);
                    if (Result.isFailure-impl(obj6)) {
                        obj6 = boolBoxBoolean;
                    }
                    handled = ((Boolean) obj6).booleanValue();
                    if (!handled) {
                        String name7 = getName();
                        String name8 = getName();
                        C00112 c00115 = new C00112(null);
                        c00102.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                        c00102.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                        c00102.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                        c00102.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                        c00102.L$4 = SpillingKt.nullOutSpilledVariable(html);
                        c00102.L$5 = SpillingKt.nullOutSpilledVariable(jsonStr);
                        c00102.L$6 = SpillingKt.nullOutSpilledVariable(resp3);
                        c00102.L$7 = SpillingKt.nullOutSpilledVariable(url6);
                        c00102.L$8 = function5;
                        c00102.Z$0 = handled;
                        c00102.label = 3;
                        $result = ExtractorApiKt.newExtractorLink$default(name7, name8, url6, (ExtractorLinkType) null, c00115, c00102, 8, (Object) null);
                        if ($result == obj) {
                            return obj;
                        }
                        resp4 = resp3;
                        jsonStr2 = jsonStr;
                        html2 = html;
                        function7 = function5;
                        function8 = function7;
                        function9 = function6;
                        html3 = referer3;
                        url7 = url5;
                        function7.invoke($result);
                    }
                    return Unit.INSTANCE;
                }
                url5 = url4;
                url6 = referer4;
                resp3 = resp2;
                boolBoxBoolean = Boxing.boxBoolean(z);
                if (Result.isFailure-impl(obj6)) {
                    obj6 = boolBoxBoolean;
                }
                handled = ((Boolean) obj6).booleanValue();
                if (!handled) {
                    String name9 = getName();
                    String name10 = getName();
                    C00112 c00116 = new C00112(null);
                    c00102.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00102.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c00102.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                    c00102.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                    c00102.L$4 = SpillingKt.nullOutSpilledVariable(html);
                    c00102.L$5 = SpillingKt.nullOutSpilledVariable(jsonStr);
                    c00102.L$6 = SpillingKt.nullOutSpilledVariable(resp3);
                    c00102.L$7 = SpillingKt.nullOutSpilledVariable(url6);
                    c00102.L$8 = function5;
                    c00102.Z$0 = handled;
                    c00102.label = 3;
                    $result = ExtractorApiKt.newExtractorLink$default(name9, name10, url6, (ExtractorLinkType) null, c00116, c00102, 8, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    resp4 = resp3;
                    jsonStr2 = jsonStr;
                    html2 = html;
                    function7 = function5;
                    function8 = function7;
                    function9 = function6;
                    html3 = referer3;
                    url7 = url5;
                    function7.invoke($result);
                }
                return Unit.INSTANCE;
            case 3:
                boolean z2 = c00102.Z$0;
                function7 = (Function1) c00102.L$8;
                resp4 = (PdlkApiResp) c00102.L$6;
                jsonStr2 = (String) c00102.L$5;
                html2 = (String) c00102.L$4;
                function8 = (Function1) c00102.L$3;
                function9 = (Function1) c00102.L$2;
                html3 = (String) c00102.L$1;
                url7 = (String) c00102.L$0;
                ResultKt.throwOnFailure($result);
                function7.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Microtv.PdlkExtractor$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Microtv.PdlkExtractor$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00112 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00112(Continuation<? super C00112> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00112 = new C00112(continuation);
            c00112.L$0 = obj;
            return c00112;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setQuality(Qualities.P1080.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003JW\u0010\u0013\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/Microtv/PdlkExtractor$PdlkApiResp;", "", "code", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "url", "data", "Lcom/Microtv/PdlkExtractor$PdlkData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/Microtv/PdlkExtractor$PdlkData;)V", "getCode", "()Ljava/lang/String;", "getUrl", "getData", "()Lcom/Microtv/PdlkExtractor$PdlkData;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Microtv"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class PdlkApiResp {

        @Nullable
        private final String code;

        @Nullable
        private final PdlkData data;

        @Nullable
        private final String url;

        public PdlkApiResp() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ PdlkApiResp copy$default(PdlkApiResp pdlkApiResp, String str, String str2, PdlkData pdlkData, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pdlkApiResp.code;
            }
            if ((i & 2) != 0) {
                str2 = pdlkApiResp.url;
            }
            if ((i & 4) != 0) {
                pdlkData = pdlkApiResp.data;
            }
            return pdlkApiResp.copy(str, str2, pdlkData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PdlkData getData() {
            return this.data;
        }

        @NotNull
        public final PdlkApiResp copy(@JsonProperty("code") @Nullable String code, @JsonProperty("url") @Nullable String url, @JsonProperty("data") @Nullable PdlkData data) {
            return new PdlkApiResp(code, url, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PdlkApiResp)) {
                return false;
            }
            PdlkApiResp pdlkApiResp = (PdlkApiResp) other;
            return Intrinsics.areEqual(this.code, pdlkApiResp.code) && Intrinsics.areEqual(this.url, pdlkApiResp.url) && Intrinsics.areEqual(this.data, pdlkApiResp.data);
        }

        public int hashCode() {
            return ((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "PdlkApiResp(code=" + this.code + ", url=" + this.url + ", data=" + this.data + ')';
        }

        public PdlkApiResp(@JsonProperty("code") @Nullable String code, @JsonProperty("url") @Nullable String url, @JsonProperty("data") @Nullable PdlkData data) {
            this.code = code;
            this.url = url;
            this.data = data;
        }

        public /* synthetic */ PdlkApiResp(String str, String str2, PdlkData pdlkData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : pdlkData);
        }

        @Nullable
        public final String getCode() {
            return this.code;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final PdlkData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000fJ\\\u0010\u0014\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/Microtv/PdlkExtractor$PdlkData;", "", "url", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "size", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getUrl", "()Ljava/lang/String;", "getName", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/Microtv/PdlkExtractor$PdlkData;", "equals", "", "other", "hashCode", "", "toString", "Microtv"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class PdlkData {

        @Nullable
        private final String name;

        @Nullable
        private final Long size;

        @Nullable
        private final String url;

        public PdlkData() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ PdlkData copy$default(PdlkData pdlkData, String str, String str2, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pdlkData.url;
            }
            if ((i & 2) != 0) {
                str2 = pdlkData.name;
            }
            if ((i & 4) != 0) {
                l = pdlkData.size;
            }
            return pdlkData.copy(str, str2, l);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getSize() {
            return this.size;
        }

        @NotNull
        public final PdlkData copy(@JsonProperty("url") @Nullable String url, @JsonProperty("name") @Nullable String name, @JsonProperty("size") @Nullable Long size) {
            return new PdlkData(url, name, size);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PdlkData)) {
                return false;
            }
            PdlkData pdlkData = (PdlkData) other;
            return Intrinsics.areEqual(this.url, pdlkData.url) && Intrinsics.areEqual(this.name, pdlkData.name) && Intrinsics.areEqual(this.size, pdlkData.size);
        }

        public int hashCode() {
            return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.size != null ? this.size.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "PdlkData(url=" + this.url + ", name=" + this.name + ", size=" + this.size + ')';
        }

        public PdlkData(@JsonProperty("url") @Nullable String url, @JsonProperty("name") @Nullable String name, @JsonProperty("size") @Nullable Long size) {
            this.url = url;
            this.name = name;
            this.size = size;
        }

        public /* synthetic */ PdlkData(String str, String str2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l);
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final Long getSize() {
            return this.size;
        }
    }
}
