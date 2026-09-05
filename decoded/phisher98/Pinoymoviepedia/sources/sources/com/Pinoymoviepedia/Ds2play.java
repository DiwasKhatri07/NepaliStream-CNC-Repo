package com.Pinoymoviepedia;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
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
import kotlin.jvm.functions.Function2;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Pinoymoviepedia/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J(\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/Pinoymoviepedia/Ds2play;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getExtractorUrl", "id", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Pinoymoviepedia"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class Ds2play extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private String name = "DoodStream";

    @NotNull
    private String mainUrl = "https://ds2play.com";

    /* JADX INFO: renamed from: com.Pinoymoviepedia.Ds2play$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pinoymoviepedia.Ds2play", f = "Extractor.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {39, 41, 44}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "$this", "url", "referer", "response0", "md5", "$this", "url", "referer", "response0", "md5", "trueUrl", "quality"}, nl = {40, 42, 43}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Ds2play.getUrl$suspendImpl(Ds2play.this, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Continuation<? super List<? extends ExtractorLink>> continuation) {
        return getUrl$suspendImpl(this, str, str2, continuation);
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

    @NotNull
    public String getExtractorUrl(@NotNull String id) {
        return "https://dood.wf/d/" + id;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x017b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x017c  */
    /* JADX WARN: Code duplicated, block: B:30:0x01be  */
    /* JADX WARN: Code duplicated, block: B:33:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:36:0x0219 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x021a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Ds2play $this, String url, String referer, Continuation<? super List<? extends ExtractorLink>> continuation) {
        C00031 c00031;
        Object obj;
        int i;
        int i2;
        String url2;
        String referer2;
        Object obj2;
        Ds2play $this2;
        String response0;
        StringBuilder sbAppend;
        MatchResult matchResultFind$default;
        String value;
        String md5;
        StringBuilder sb;
        Ds2play $this3;
        Object obj3;
        String response1;
        String url3;
        Ds2play $this4;
        StringBuilder sb2;
        String referer3;
        MatchResult matchResultFind$default2;
        String str;
        List groupValues;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = $this.new C00031(continuation);
            }
        } else {
            c00031 = $this.new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00032.L$0 = $this;
                c00032.L$1 = url;
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00032.label = 1;
                obj = coroutine_suspended;
                i = 0;
                i2 = 2;
                Object obj4 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4094, (Object) null);
                c00032 = c00032;
                if (obj4 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                obj2 = obj4;
                $this2 = $this;
                response0 = ((NiceResponse) obj2).getText();
                sbAppend = new StringBuilder().append($this2.getMainUrl());
                matchResultFind$default = Regex.find$default(new Regex("/pass_md5/[^']*"), response0, i, i2, (Object) null);
                if (matchResultFind$default == null && (value = matchResultFind$default.getValue()) != null) {
                    md5 = sbAppend.append(value).toString();
                    sb = new StringBuilder();
                    Requests app2 = MainActivityKt.getApp();
                    c00032.L$0 = $this2;
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00032.L$3 = response0;
                    c00032.L$4 = md5;
                    c00032.L$5 = sb;
                    c00032.label = i2;
                    C00031 c00033 = c00032;
                    $this3 = $this2;
                    obj3 = Requests.get$default(app2, md5, (Map) null, url2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 4090, (Object) null);
                    c00032 = c00033;
                    if (obj3 == obj) {
                        return obj;
                    }
                    response1 = md5;
                    url3 = url2;
                    $this4 = $this3;
                    sb2 = sb;
                    referer3 = response0;
                    String trueUrl = sb2.append(((NiceResponse) obj3).getText()).append("zUEJeL3mUN?token=").append(StringsKt.substringAfterLast$default(response1, "/", (String) null, i2, (Object) null)).toString();
                    matchResultFind$default2 = Regex.find$default(new Regex("\\d{3,4}p"), StringsKt.substringBefore$default(StringsKt.substringAfter$default(referer3, "<title>", (String) null, i2, (Object) null), "</title>", (String) null, i2, (Object) null), i, i2, (Object) null);
                    if (matchResultFind$default2 != null || (groupValues = matchResultFind$default2.getGroupValues()) == null) {
                        str = null;
                    } else {
                        str = (String) groupValues.get(i);
                    }
                    String quality = str;
                    String trueUrl2 = $this4.getName();
                    String name = $this4.getName();
                    ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                    C00042 c00042 = $this4.new C00042(quality, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(referer3);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(response1);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(trueUrl);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(quality);
                    c00032.label = 3;
                    $result = ExtractorApiKt.newExtractorLink(trueUrl2, name, trueUrl, extractorLinkType, c00042, c00032);
                    if ($result == obj) {
                        return obj;
                    }
                    return CollectionsKt.listOf($result);
                }
                return null;
            case 1:
                String referer4 = (String) c00032.L$2;
                String url4 = (String) c00032.L$1;
                Ds2play $this5 = (Ds2play) c00032.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this5;
                obj = coroutine_suspended;
                referer2 = referer4;
                url2 = url4;
                i = 0;
                obj2 = $result;
                i2 = 2;
                response0 = ((NiceResponse) obj2).getText();
                sbAppend = new StringBuilder().append($this2.getMainUrl());
                matchResultFind$default = Regex.find$default(new Regex("/pass_md5/[^']*"), response0, i, i2, (Object) null);
                if (matchResultFind$default == null) {
                    return null;
                }
                md5 = sbAppend.append(value).toString();
                sb = new StringBuilder();
                Requests app3 = MainActivityKt.getApp();
                c00032.L$0 = $this2;
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00032.L$3 = response0;
                c00032.L$4 = md5;
                c00032.L$5 = sb;
                c00032.label = i2;
                C00031 c00034 = c00032;
                $this3 = $this2;
                obj3 = Requests.get$default(app3, md5, (Map) null, url2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00034, 4090, (Object) null);
                c00032 = c00034;
                if (obj3 == obj) {
                    return obj;
                }
                response1 = md5;
                url3 = url2;
                $this4 = $this3;
                sb2 = sb;
                referer3 = response0;
                String trueUrl3 = sb2.append(((NiceResponse) obj3).getText()).append("zUEJeL3mUN?token=").append(StringsKt.substringAfterLast$default(response1, "/", (String) null, i2, (Object) null)).toString();
                matchResultFind$default2 = Regex.find$default(new Regex("\\d{3,4}p"), StringsKt.substringBefore$default(StringsKt.substringAfter$default(referer3, "<title>", (String) null, i2, (Object) null), "</title>", (String) null, i2, (Object) null), i, i2, (Object) null);
                if (matchResultFind$default2 != null) {
                    str = null;
                } else {
                    str = null;
                }
                String quality2 = str;
                String trueUrl4 = $this4.getName();
                String name2 = $this4.getName();
                ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                C00042 c00043 = $this4.new C00042(quality2, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(referer3);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(response1);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(trueUrl3);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(quality2);
                c00032.label = 3;
                $result = ExtractorApiKt.newExtractorLink(trueUrl4, name2, trueUrl3, extractorLinkType2, c00043, c00032);
                if ($result == obj) {
                    return obj;
                }
                return CollectionsKt.listOf($result);
            case 2:
                sb2 = (StringBuilder) c00032.L$5;
                String md6 = (String) c00032.L$4;
                String response2 = (String) c00032.L$3;
                String referer5 = (String) c00032.L$2;
                url3 = (String) c00032.L$1;
                Ds2play $this6 = (Ds2play) c00032.L$0;
                ResultKt.throwOnFailure($result);
                referer2 = referer5;
                i = 0;
                referer3 = response2;
                i2 = 2;
                response1 = md6;
                $this4 = $this6;
                obj = coroutine_suspended;
                obj3 = $result;
                String trueUrl5 = sb2.append(((NiceResponse) obj3).getText()).append("zUEJeL3mUN?token=").append(StringsKt.substringAfterLast$default(response1, "/", (String) null, i2, (Object) null)).toString();
                matchResultFind$default2 = Regex.find$default(new Regex("\\d{3,4}p"), StringsKt.substringBefore$default(StringsKt.substringAfter$default(referer3, "<title>", (String) null, i2, (Object) null), "</title>", (String) null, i2, (Object) null), i, i2, (Object) null);
                if (matchResultFind$default2 != null) {
                    str = null;
                } else {
                    str = null;
                }
                String quality3 = str;
                String trueUrl6 = $this4.getName();
                String name3 = $this4.getName();
                ExtractorLinkType extractorLinkType3 = ExtractorLinkType.M3U8;
                C00042 c00044 = $this4.new C00042(quality3, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(referer3);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(response1);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(trueUrl5);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(quality3);
                c00032.label = 3;
                $result = ExtractorApiKt.newExtractorLink(trueUrl6, name3, trueUrl5, extractorLinkType3, c00044, c00032);
                if ($result == obj) {
                    return obj;
                }
                return CollectionsKt.listOf($result);
            case 3:
                ResultKt.throwOnFailure($result);
                return CollectionsKt.listOf($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Pinoymoviepedia.Ds2play$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pinoymoviepedia.Ds2play$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(String str, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$quality = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = Ds2play.this.new C00042(this.$quality, continuation);
            c00042.L$0 = obj;
            return c00042;
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
                    $this$newExtractorLink.setReferer(Ds2play.this.getMainUrl());
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$quality));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
