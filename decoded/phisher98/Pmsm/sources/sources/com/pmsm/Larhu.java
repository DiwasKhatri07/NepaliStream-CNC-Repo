package com.pmsm;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Pmsm/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/pmsm/Larhu;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Pmsm"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/pmsm/Larhu\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,109:1\n2068#2,2:110\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/pmsm/Larhu\n*L\n59#1:110,2\n*E\n"})
public final class Larhu extends ExtractorApi {

    @NotNull
    private String name = "Larhu";

    @NotNull
    private String mainUrl = "https://larhu.website";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.pmsm.Larhu$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.pmsm.Larhu", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {51, 59, 62, 75}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "doc", "streamurl", "url", "referer", "subtitleCallback", "callback", "doc", "streamurl", "url", "referer", "subtitleCallback", "callback", "doc", "streamurl"}, nl = {53, 110, 61, 74}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Larhu.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x01a2 A[LOOP:0: B:33:0x019c->B:35:0x01a2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x0241 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x0242  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00001 c00001;
        Larhu larhu;
        Object obj;
        Continuation continuation2;
        Object obj2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        MatchResult matchResultFind$default;
        List groupValues;
        String streamurl;
        String url3;
        Object objNewExtractorLink;
        String streamurl2;
        String referer3;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
        String doc;
        Object objGenerateM3u8$default;
        String url4;
        String referer4;
        Function1<? super SubtitleFile, Unit> function8;
        Function1<? super ExtractorLink, Unit> function9;
        String doc2;
        String streamurl3;
        String streamurl4;
        String url5;
        String url6;
        String doc3;
        Function1<? super SubtitleFile, Unit> function10;
        Function1<? super ExtractorLink, Unit> function11;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
                larhu = this;
            } else {
                larhu = this;
                c00001 = larhu.new C00001(continuation);
            }
        } else {
            larhu = this;
            c00001 = larhu.new C00001(continuation);
        }
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00002.L$0 = url;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00002.L$3 = function2;
                c00002.label = 1;
                obj = coroutine_suspended;
                continuation2 = null;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                c00002 = c00002;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                String doc4 = ((NiceResponse) obj2).getText();
                matchResultFind$default = Regex.find$default(new Regex("file\\s*:\\s*\"([^\"]+\\.(m3u8|mp4))\""), doc4, 0, 2, continuation2);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (streamurl = (String) groupValues.get(1)) == null) {
                    return Unit.INSTANCE;
                }
                if (!StringsKt.contains(streamurl, ".m3u8", true)) {
                    url3 = url2;
                    String name = larhu.getName();
                    String name2 = larhu.getName();
                    ExtractorLinkType extractorLinkType = ExtractorLinkType.VIDEO;
                    C00012 c00012 = new C00012(url3, continuation2);
                    c00002.L$0 = url3;
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00002.L$3 = function4;
                    c00002.L$4 = SpillingKt.nullOutSpilledVariable(doc4);
                    c00002.L$5 = streamurl;
                    c00002.L$6 = function4;
                    c00002.label = 3;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, streamurl, extractorLinkType, c00012, c00002);
                    if (objNewExtractorLink == obj) {
                        return obj;
                    }
                    streamurl2 = streamurl;
                    referer3 = referer2;
                    function5 = function3;
                    function6 = function4;
                    function7 = function6;
                    doc = doc4;
                    function6.invoke(objNewExtractorLink);
                    streamurl4 = streamurl2;
                    url6 = url3;
                    url5 = referer3;
                    function10 = function5;
                    doc3 = doc;
                    String name3 = larhu.getName();
                    String name4 = larhu.getName();
                    ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                    C00023 c00023 = new C00023(url6, continuation2);
                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(url5);
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                    c00002.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                    c00002.L$4 = SpillingKt.nullOutSpilledVariable(doc3);
                    c00002.L$5 = SpillingKt.nullOutSpilledVariable(streamurl4);
                    c00002.L$6 = function7;
                    c00002.label = 4;
                    $result = ExtractorApiKt.newExtractorLink(name3, name4, streamurl4, extractorLinkType2, c00023, c00002);
                    if ($result == obj) {
                        return obj;
                    }
                    function11 = function7;
                    function11.invoke($result);
                    return Unit.INSTANCE;
                }
                M3u8Helper.Companion companion = M3u8Helper.Companion;
                String name5 = larhu.getName();
                c00002.L$0 = url2;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$3 = function4;
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(doc4);
                c00002.L$5 = streamurl;
                c00002.label = 2;
                C00001 c00003 = c00002;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, name5, url2, url2, (Integer) null, (Map) null, (String) null, c00003, 56, (Object) null);
                String url7 = url2;
                c00002 = c00003;
                if (objGenerateM3u8$default == obj) {
                    return obj;
                }
                url4 = url7;
                referer4 = referer2;
                function8 = function3;
                function9 = function4;
                doc2 = doc4;
                streamurl3 = streamurl;
                Iterable $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                for (Object element$iv : $this$forEach$iv) {
                    function9.invoke(element$iv);
                }
                streamurl4 = streamurl3;
                url5 = referer4;
                url6 = url4;
                doc3 = doc2;
                function10 = function8;
                function7 = function9;
                String name6 = larhu.getName();
                String name7 = larhu.getName();
                ExtractorLinkType extractorLinkType3 = ExtractorLinkType.M3U8;
                C00023 c00024 = new C00023(url6, continuation2);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url5);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(doc3);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(streamurl4);
                c00002.L$6 = function7;
                c00002.label = 4;
                $result = ExtractorApiKt.newExtractorLink(name6, name7, streamurl4, extractorLinkType3, c00024, c00002);
                if ($result == obj) {
                    return obj;
                }
                function11 = function7;
                function11.invoke($result);
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function12 = (Function1) c00002.L$3;
                Function1<? super SubtitleFile, Unit> function13 = (Function1) c00002.L$2;
                String referer5 = (String) c00002.L$1;
                String url8 = (String) c00002.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                function4 = function12;
                function3 = function13;
                referer2 = referer5;
                obj2 = $result;
                continuation2 = null;
                url2 = url8;
                String doc5 = ((NiceResponse) obj2).getText();
                matchResultFind$default = Regex.find$default(new Regex("file\\s*:\\s*\"([^\"]+\\.(m3u8|mp4))\""), doc5, 0, 2, continuation2);
                if (matchResultFind$default != null) {
                }
                return Unit.INSTANCE;
            case 2:
                streamurl3 = (String) c00002.L$5;
                doc2 = (String) c00002.L$4;
                function9 = (Function1) c00002.L$3;
                function8 = (Function1) c00002.L$2;
                referer4 = (String) c00002.L$1;
                url4 = (String) c00002.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                objGenerateM3u8$default = $result;
                continuation2 = null;
                Iterable $this$forEach$iv2 = (Iterable) objGenerateM3u8$default;
                while (r12.hasNext()) {
                    function9.invoke(element$iv);
                }
                streamurl4 = streamurl3;
                url5 = referer4;
                url6 = url4;
                doc3 = doc2;
                function10 = function8;
                function7 = function9;
                String name8 = larhu.getName();
                String name9 = larhu.getName();
                ExtractorLinkType extractorLinkType4 = ExtractorLinkType.M3U8;
                C00023 c00025 = new C00023(url6, continuation2);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url5);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(doc3);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(streamurl4);
                c00002.L$6 = function7;
                c00002.label = 4;
                $result = ExtractorApiKt.newExtractorLink(name8, name9, streamurl4, extractorLinkType4, c00025, c00002);
                if ($result == obj) {
                    return obj;
                }
                function11 = function7;
                function11.invoke($result);
                return Unit.INSTANCE;
            case 3:
                function6 = (Function1) c00002.L$6;
                streamurl2 = (String) c00002.L$5;
                doc = (String) c00002.L$4;
                function7 = (Function1) c00002.L$3;
                function5 = (Function1) c00002.L$2;
                referer3 = (String) c00002.L$1;
                url3 = (String) c00002.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                objNewExtractorLink = $result;
                continuation2 = null;
                function6.invoke(objNewExtractorLink);
                streamurl4 = streamurl2;
                url6 = url3;
                url5 = referer3;
                function10 = function5;
                doc3 = doc;
                String name10 = larhu.getName();
                String name11 = larhu.getName();
                ExtractorLinkType extractorLinkType5 = ExtractorLinkType.M3U8;
                C00023 c00026 = new C00023(url6, continuation2);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url5);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(doc3);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(streamurl4);
                c00002.L$6 = function7;
                c00002.label = 4;
                $result = ExtractorApiKt.newExtractorLink(name10, name11, streamurl4, extractorLinkType5, c00026, c00002);
                if ($result == obj) {
                    return obj;
                }
                function11 = function7;
                function11.invoke($result);
                return Unit.INSTANCE;
            case 4:
                function11 = (Function1) c00002.L$6;
                ResultKt.throwOnFailure($result);
                function11.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.pmsm.Larhu$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.pmsm.Larhu$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00012 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00012(String str, Continuation<? super C00012> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00012 = new C00012(this.$url, continuation);
            c00012.L$0 = obj;
            return c00012;
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
                    $this$newExtractorLink.setReferer(this.$url);
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.pmsm.Larhu$getUrl$3 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.pmsm.Larhu$getUrl$3", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00023 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00023(String str, Continuation<? super C00023> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00023 = new C00023(this.$url, continuation);
            c00023.L$0 = obj;
            return c00023;
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
                    $this$newExtractorLink.setReferer(this.$url);
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
