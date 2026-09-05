package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
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
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/phisher98/M4ufree;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findIn", "data", "Source", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/M4ufree\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,4003:1\n1#2:4004\n1#2:4008\n93#3,2:4005\n63#3:4007\n64#3,15:4009\n95#3,2:4026\n50#4:4024\n43#4:4025\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/M4ufree\n*L\n259#1:4008\n259#1:4005,2\n259#1:4007\n259#1:4009,15\n259#1:4026,2\n259#1:4024\n259#1:4025\n*E\n"})
public class M4ufree extends ExtractorApi {

    @NotNull
    private final String name = "M4ufree";

    @NotNull
    private final String mainUrl = "https://play.playm4u.xyz";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.M4ufree$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.M4ufree", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {246, 252, 262}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "document", "script", "idFile", "idUser", "$this", "url", "referer", "subtitleCallback", "callback", "document", "script", "idFile", "idUser", "video"}, nl = {247, 259, 261}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00431 extends ContinuationImpl {
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

        C00431(Continuation<? super C00431> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return M4ufree.getUrl$suspendImpl(M4ufree.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:30:0x022c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0233  */
    /* JADX WARN: Code duplicated, block: B:38:0x0263  */
    /* JADX WARN: Code duplicated, block: B:50:0x029f  */
    /* JADX WARN: Code duplicated, block: B:51:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:60:0x02bd A[Catch: Exception -> 0x02d8, TRY_LEAVE, TryCatch #4 {Exception -> 0x02d8, blocks: (B:48:0x0299, B:52:0x02a2, B:60:0x02bd, B:59:0x02b7, B:47:0x028f, B:54:0x02a8), top: B:91:0x028f, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:72:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:75:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:77:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:79:0x0354 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0355  */
    /* JADX WARN: Code duplicated, block: B:92:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x02a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static /* synthetic */ Object getUrl$suspendImpl(M4ufree $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00431 c00431;
        char c;
        Object obj;
        int i;
        String url2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object obj2;
        String referer2;
        Element elementSelectFirst;
        String script;
        String idUser;
        Document document;
        String idFile;
        String script2;
        Object objPost$default;
        String url3;
        Function1<? super SubtitleFile, Unit> function5;
        String referer3;
        Function1<? super ExtractorLink, Unit> function6;
        M4ufree $this2;
        String it;
        Object obj3;
        Object obj4;
        Object obj5;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        Source source;
        String video;
        String name;
        String name2;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function7;
        M4ufree $this3 = $this;
        if (continuation instanceof C00431) {
            c00431 = (C00431) continuation;
            if ((c00431.label & Integer.MIN_VALUE) != 0) {
                c00431.label -= Integer.MIN_VALUE;
            } else {
                c00431 = $this3.new C00431(continuation);
            }
        } else {
            c00431 = $this3.new C00431(continuation);
        }
        C00431 c00432 = c00431;
        Object $result = c00432.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00432.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests session = StreamPlayExtractorKt.getSession();
                c00432.L$0 = $this3;
                c00432.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00432.L$2 = referer;
                c00432.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00432.L$4 = function2;
                c00432.label = 1;
                c = 1;
                obj = coroutine_suspended;
                i = 2;
                Object obj6 = Requests.get$default(session, url, (Map) null, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00432, 4090, (Object) null);
                c00432 = c00432;
                if (obj6 == obj) {
                    return obj;
                }
                url2 = url;
                function3 = function1;
                function4 = function2;
                obj2 = obj6;
                referer2 = referer;
                Document document2 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document2.selectFirst("script:containsData(idfile =)");
                if (elementSelectFirst != null || (script = elementSelectFirst.data()) == null) {
                    return Unit.INSTANCE;
                }
                String idFile2 = $this3.findIn("idfile", script);
                String idUser2 = $this3.findIn("idUser", script);
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("referrer", String.valueOf(referer2)));
                Pair[] pairArr = new Pair[i];
                pairArr[0] = TuplesKt.to("Accept", "*/*");
                pairArr[c] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                Map mapMapOf2 = MapsKt.mapOf(pairArr);
                c00432.L$0 = $this3;
                c00432.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00432.L$2 = referer2;
                c00432.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00432.L$4 = function4;
                c00432.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                c00432.L$6 = SpillingKt.nullOutSpilledVariable(script);
                c00432.L$7 = SpillingKt.nullOutSpilledVariable(idFile2);
                c00432.L$8 = SpillingKt.nullOutSpilledVariable(idUser2);
                c00432.label = i;
                C00431 c00433 = c00432;
                String referer4 = referer2;
                Function1<? super ExtractorLink, Unit> function8 = function4;
                idUser = idUser2;
                document = document2;
                idFile = idFile2;
                script2 = script;
                objPost$default = Requests.post$default(StreamPlayExtractorKt.getSession(), "https://api-plhq.playm4u.xyz/apidatard/" + idUser2 + '/' + idFile2, mapMapOf2, (String) null, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00433, 65500, (Object) null);
                c00432 = c00433;
                if (objPost$default == obj) {
                    return obj;
                }
                url3 = url2;
                function5 = function3;
                referer3 = referer4;
                function6 = function8;
                $this2 = $this3;
                it = ((NiceResponse) objPost$default).getText();
                AppUtils appUtils = AppUtils.INSTANCE;
                if (it == null) {
                    try {
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(Source.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj3) == null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Source.class), (List) null, 2, (Object) null));
                                    break;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        Result.Companion companion4 = Result.Companion;
                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e) {
                                        obj4 = null;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        if (Result.isFailure-impl(obj3)) {
                            obj5 = null;
                        } else {
                            obj5 = obj3;
                        }
                        deserializationStrategy = (KSerializer) obj5;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(it, new TypeReference<Source>() { // from class: com.phisher98.M4ufree$getUrl$lambda$0$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th4) {
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(it, new TypeReference<Source>() { // from class: com.phisher98.M4ufree$getUrl$lambda$0$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(it, new TypeReference<Source>() { // from class: com.phisher98.M4ufree$getUrl$lambda$0$$inlined$tryParseJson$1
                            });
                        }
                        obj4 = objDecodeFromString;
                    } catch (Exception e3) {
                        obj4 = null;
                        source = (Source) obj4;
                        if (source != null) {
                            video = source.getData();
                        } else {
                            video = null;
                        }
                        name = $this2.getName();
                        name2 = $this2.getName();
                        if (video == null) {
                            return Unit.INSTANCE;
                        }
                        ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                        C00442 c00442 = new C00442(referer3, null);
                        c00432.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                        c00432.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                        c00432.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                        c00432.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                        c00432.L$4 = SpillingKt.nullOutSpilledVariable(function6);
                        c00432.L$5 = SpillingKt.nullOutSpilledVariable(document);
                        c00432.L$6 = SpillingKt.nullOutSpilledVariable(script2);
                        c00432.L$7 = SpillingKt.nullOutSpilledVariable(idFile);
                        c00432.L$8 = SpillingKt.nullOutSpilledVariable(idUser);
                        c00432.L$9 = SpillingKt.nullOutSpilledVariable(video);
                        c00432.L$10 = function6;
                        c00432.label = 3;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, video, infer_type, c00442, c00432);
                        if (objNewExtractorLink == obj) {
                            return obj;
                        }
                        function7 = function6;
                        function7.invoke(objNewExtractorLink);
                        return Unit.INSTANCE;
                    }
                    break;
                } else {
                    obj4 = null;
                }
                source = (Source) obj4;
                if (source != null) {
                    video = source.getData();
                } else {
                    video = null;
                }
                name = $this2.getName();
                name2 = $this2.getName();
                if (video == null) {
                    return Unit.INSTANCE;
                }
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                C00442 c00443 = new C00442(referer3, null);
                c00432.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00432.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00432.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c00432.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                c00432.L$4 = SpillingKt.nullOutSpilledVariable(function6);
                c00432.L$5 = SpillingKt.nullOutSpilledVariable(document);
                c00432.L$6 = SpillingKt.nullOutSpilledVariable(script2);
                c00432.L$7 = SpillingKt.nullOutSpilledVariable(idFile);
                c00432.L$8 = SpillingKt.nullOutSpilledVariable(idUser);
                c00432.L$9 = SpillingKt.nullOutSpilledVariable(video);
                c00432.L$10 = function6;
                c00432.label = 3;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, video, infer_type2, c00443, c00432);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function7 = function6;
                function7.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            case 1:
                function4 = (Function1) c00432.L$4;
                Function1<? super SubtitleFile, Unit> function9 = (Function1) c00432.L$3;
                String referer5 = (String) c00432.L$2;
                String url4 = (String) c00432.L$1;
                $this3 = (M4ufree) c00432.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = $result;
                obj = coroutine_suspended;
                function3 = function9;
                referer2 = referer5;
                url2 = url4;
                i = 2;
                c = 1;
                Document document3 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document3.selectFirst("script:containsData(idfile =)");
                if (elementSelectFirst != null) {
                }
                return Unit.INSTANCE;
            case 2:
                String idUser3 = (String) c00432.L$8;
                String idFile3 = (String) c00432.L$7;
                String script3 = (String) c00432.L$6;
                Document document4 = (Document) c00432.L$5;
                function6 = (Function1) c00432.L$4;
                function5 = (Function1) c00432.L$3;
                referer3 = (String) c00432.L$2;
                url3 = (String) c00432.L$1;
                M4ufree $this4 = (M4ufree) c00432.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                idUser = idUser3;
                idFile = idFile3;
                script2 = script3;
                document = document4;
                objPost$default = $result;
                $this2 = $this4;
                it = ((NiceResponse) objPost$default).getText();
                AppUtils appUtils2 = AppUtils.INSTANCE;
                if (it == null) {
                    Result.Companion companion5 = Result.Companion;
                    KType kTypeTypeOf2 = Reflection.typeOf(Source.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                    if (Result.exceptionOrNull-impl(obj3) == null) {
                        Result.Companion companion6 = Result.Companion;
                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Source.class), (List) null, 2, (Object) null));
                        break;
                    }
                    if (Result.isFailure-impl(obj3)) {
                        obj5 = null;
                    } else {
                        obj5 = obj3;
                    }
                    deserializationStrategy = (KSerializer) obj5;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(it, new TypeReference<Source>() { // from class: com.phisher98.M4ufree$getUrl$lambda$0$$inlined$tryParseJson$1
                        });
                    }
                    obj4 = objDecodeFromString;
                    break;
                } else {
                    obj4 = null;
                }
                source = (Source) obj4;
                if (source != null) {
                    video = source.getData();
                } else {
                    video = null;
                }
                name = $this2.getName();
                name2 = $this2.getName();
                if (video == null) {
                    return Unit.INSTANCE;
                }
                ExtractorLinkType infer_type3 = ExtractorApiKt.getINFER_TYPE();
                C00442 c00444 = new C00442(referer3, null);
                c00432.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00432.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00432.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c00432.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                c00432.L$4 = SpillingKt.nullOutSpilledVariable(function6);
                c00432.L$5 = SpillingKt.nullOutSpilledVariable(document);
                c00432.L$6 = SpillingKt.nullOutSpilledVariable(script2);
                c00432.L$7 = SpillingKt.nullOutSpilledVariable(idFile);
                c00432.L$8 = SpillingKt.nullOutSpilledVariable(idUser);
                c00432.L$9 = SpillingKt.nullOutSpilledVariable(video);
                c00432.L$10 = function6;
                c00432.label = 3;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, video, infer_type3, c00444, c00432);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function7 = function6;
                function7.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            case 3:
                function7 = (Function1) c00432.L$10;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function7.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.M4ufree$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.M4ufree$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00442 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $referer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00442(String str, Continuation<? super C00442> continuation) {
            super(2, continuation);
            this.$referer = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00442 = new C00442(this.$referer, continuation);
            c00442.L$0 = obj;
            return c00442;
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
                    String str = this.$referer;
                    if (str == null) {
                        str = "";
                    }
                    $this$newExtractorLink.setReferer(str);
                    $this$newExtractorLink.setQuality(Qualities.P720.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String findIn(String $this$findIn, String data) {
        List groupValues;
        MatchResult matchResultFind$default = Regex.find$default(new Regex($this$findIn + "\\s*=\\s*[\"'](\\S+)[\"'];"), data, 0, 2, (Object) null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
            return null;
        }
        return (String) groupValues.get(1);
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/phisher98/M4ufree$Source;", "", "data", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Source {

        @Nullable
        private final String data;

        /* JADX WARN: Illegal instructions before constructor call */
        public Source() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ Source copy$default(Source source, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = source.data;
            }
            return source.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getData() {
            return this.data;
        }

        @NotNull
        public final Source copy(@JsonProperty("data") @Nullable String data) {
            return new Source(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Source) && Intrinsics.areEqual(this.data, ((Source) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "Source(data=" + this.data + ')';
        }

        public Source(@JsonProperty("data") @Nullable String data) {
            this.data = data;
        }

        public /* synthetic */ Source(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getData() {
            return this.data;
        }
    }
}
