package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
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
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00150\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00150\u0019H\u0096@¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/phisher98/Ridoo;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "setMainUrl", "(Ljava/lang/String;)V", "requiresReferer", "", "getRequiresReferer", "()Z", "defaulQuality", "", "getDefaulQuality", "()I", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class Ridoo extends ExtractorApi {

    @NotNull
    private final String name = "Ridoo";

    @NotNull
    private String mainUrl = "https://ridoo.net";
    private final boolean requiresReferer = true;
    private final int defaulQuality = Qualities.P1080.getValue();

    /* JADX INFO: renamed from: com.phisher98.Ridoo$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Ridoo", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {599, 608}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "response", "script", "m3u8", "quality"}, nl = {600, 607}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00611 extends ContinuationImpl {
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

        C00611(Continuation<? super C00611> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Ridoo.getUrl$suspendImpl(Ridoo.this, null, null, null, null, (Continuation) this);
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

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    public int getDefaulQuality() {
        return this.defaulQuality;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:27:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:28:0x0105  */
    /* JADX WARN: Code duplicated, block: B:30:0x0111  */
    /* JADX WARN: Code duplicated, block: B:31:0x0116  */
    /* JADX WARN: Code duplicated, block: B:34:0x0121  */
    /* JADX WARN: Code duplicated, block: B:36:0x0124  */
    /* JADX WARN: Code duplicated, block: B:41:0x013c  */
    /* JADX WARN: Code duplicated, block: B:47:0x015c  */
    /* JADX WARN: Code duplicated, block: B:50:0x016a  */
    /* JADX WARN: Code duplicated, block: B:52:0x016d  */
    /* JADX WARN: Code duplicated, block: B:54:0x01be A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Ridoo $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00611 c00611;
        Object obj;
        Object obj2;
        Ridoo $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        NiceResponse response;
        String packed;
        boolean z;
        Element elementSelectFirst;
        String strData;
        String script;
        Regex regex;
        MatchResult matchResultFind$default;
        String m3u8;
        MatchResult matchResultFind$default2;
        String quality;
        String m3u9;
        String m3u10;
        String name;
        Function1<? super ExtractorLink, Unit> function5;
        List groupValues;
        List groupValues2;
        if (continuation instanceof C00611) {
            c00611 = (C00611) continuation;
            if ((c00611.label & Integer.MIN_VALUE) != 0) {
                c00611.label -= Integer.MIN_VALUE;
            } else {
                c00611 = $this.new C00611(continuation);
            }
        } else {
            c00611 = $this.new C00611(continuation);
        }
        C00611 c00612 = c00611;
        Object $result = c00612.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00612.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00612.L$0 = $this;
                c00612.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00612.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00612.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00612.L$4 = function2;
                c00612.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00612, 4090, (Object) null);
                c00612 = c00612;
                if (obj2 == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                response = (NiceResponse) obj2;
                packed = ExtractorApiKt.getPacked(response.getText());
                if (packed != null || packed.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    elementSelectFirst = response.getDocument().selectFirst("script:containsData(sources:)");
                    if (elementSelectFirst != null) {
                        strData = elementSelectFirst.data();
                    } else {
                        strData = null;
                    }
                } else {
                    strData = ExtractorApiKt.getAndUnpack(response.getText());
                }
                script = strData;
                regex = new Regex("file:\\s*\"(.*?m3u8.*?)\"");
                if (script == null) {
                    return Unit.INSTANCE;
                }
                matchResultFind$default = Regex.find$default(regex, script, 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues2 = matchResultFind$default.getGroupValues()) == null) {
                    m3u8 = null;
                } else {
                    m3u8 = (String) CollectionsKt.getOrNull(groupValues2, 1);
                }
                matchResultFind$default2 = Regex.find$default(new Regex("qualityLabels.*\"(\\d{3,4})[pP]\""), script, 0, 2, (Object) null);
                if (matchResultFind$default2 != null || (groupValues = matchResultFind$default2.getGroupValues()) == null) {
                    quality = null;
                } else {
                    quality = (String) groupValues.get(1);
                }
                m3u9 = m3u8;
                m3u10 = $this2.getName();
                name = $this2.getName();
                if (m3u9 == null) {
                    return Unit.INSTANCE;
                }
                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                C00622 c00622 = $this2.new C00622(quality, null);
                c00612.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00612.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00612.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00612.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00612.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                c00612.L$5 = SpillingKt.nullOutSpilledVariable(response);
                c00612.L$6 = SpillingKt.nullOutSpilledVariable(script);
                c00612.L$7 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00612.L$8 = SpillingKt.nullOutSpilledVariable(quality);
                c00612.L$9 = function4;
                c00612.label = 2;
                $result = ExtractorApiKt.newExtractorLink(m3u10, name, m3u9, infer_type, c00622, c00612);
                if ($result == obj) {
                    return obj;
                }
                function5 = function4;
                function5.invoke($result);
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function6 = (Function1) c00612.L$4;
                Function1<? super SubtitleFile, Unit> function7 = (Function1) c00612.L$3;
                String referer3 = (String) c00612.L$2;
                String url3 = (String) c00612.L$1;
                Ridoo $this3 = (Ridoo) c00612.L$0;
                ResultKt.throwOnFailure($result);
                function4 = function6;
                function3 = function7;
                referer2 = referer3;
                url2 = url3;
                $this2 = $this3;
                obj = coroutine_suspended;
                obj2 = $result;
                response = (NiceResponse) obj2;
                packed = ExtractorApiKt.getPacked(response.getText());
                if (packed != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    strData = ExtractorApiKt.getAndUnpack(response.getText());
                } else {
                    elementSelectFirst = response.getDocument().selectFirst("script:containsData(sources:)");
                    if (elementSelectFirst != null) {
                        strData = elementSelectFirst.data();
                    } else {
                        strData = null;
                    }
                }
                script = strData;
                regex = new Regex("file:\\s*\"(.*?m3u8.*?)\"");
                if (script == null) {
                    return Unit.INSTANCE;
                }
                matchResultFind$default = Regex.find$default(regex, script, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    m3u8 = null;
                } else {
                    m3u8 = null;
                }
                matchResultFind$default2 = Regex.find$default(new Regex("qualityLabels.*\"(\\d{3,4})[pP]\""), script, 0, 2, (Object) null);
                if (matchResultFind$default2 != null) {
                    quality = null;
                } else {
                    quality = null;
                }
                m3u9 = m3u8;
                m3u10 = $this2.getName();
                name = $this2.getName();
                if (m3u9 == null) {
                    return Unit.INSTANCE;
                }
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                C00622 c00623 = $this2.new C00622(quality, null);
                c00612.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00612.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00612.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00612.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00612.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                c00612.L$5 = SpillingKt.nullOutSpilledVariable(response);
                c00612.L$6 = SpillingKt.nullOutSpilledVariable(script);
                c00612.L$7 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00612.L$8 = SpillingKt.nullOutSpilledVariable(quality);
                c00612.L$9 = function4;
                c00612.label = 2;
                $result = ExtractorApiKt.newExtractorLink(m3u10, name, m3u9, infer_type2, c00623, c00612);
                if ($result == obj) {
                    return obj;
                }
                function5 = function4;
                function5.invoke($result);
                return Unit.INSTANCE;
            case 2:
                function5 = (Function1) c00612.L$9;
                ResultKt.throwOnFailure($result);
                function5.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Ridoo$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Ridoo$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00622 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00622(String str, Continuation<? super C00622> continuation) {
            super(2, continuation);
            this.$quality = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00622 = Ridoo.this.new C00622(this.$quality, continuation);
            c00622.L$0 = obj;
            return c00622;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Integer intOrNull;
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setReferer(Ridoo.this.getMainUrl());
                    String str = this.$quality;
                    $this$newExtractorLink.setQuality((str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? Ridoo.this.getDefaulQuality() : intOrNull.intValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
