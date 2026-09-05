package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
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
import kotlin.jvm.functions.Function2;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/OnePace/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/phisher98/Streamruby;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "OnePace"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class Streamruby extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private String name = "Streamruby";

    @NotNull
    private String mainUrl = "streamruby.com";

    /* JADX INFO: renamed from: com.phisher98.Streamruby$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Streamruby", f = "Extractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3}, l = {35, 38, 51, 54}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "newurl", "$this", "url", "referer", "newurl", "txt", "m3u8", "$this", "url", "referer", "$this", "url", "referer", "txt", "m3u8"}, nl = {36, 37, 52, 53}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Streamruby.getUrl$suspendImpl(Streamruby.this, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:27:0x014f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0198 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0199  */
    /* JADX WARN: Code duplicated, block: B:43:0x0208  */
    /* JADX WARN: Code duplicated, block: B:46:0x024b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x024c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Streamruby $this, String url, String referer, Continuation<? super List<? extends ExtractorLink>> continuation) {
        C00121 c00121;
        Object obj;
        int i;
        Object obj2;
        Streamruby $this2;
        String url2;
        String referer2;
        Object obj3;
        String str;
        int i2;
        Object obj4;
        Streamruby $this3;
        String url3;
        String referer3;
        String newurl;
        MatchResult matchResultFind$default;
        String str2;
        Object objNewExtractorLink;
        List groupValues;
        MatchResult matchResultFind$default2;
        String str3;
        Object objNewExtractorLink2;
        List groupValues2;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = $this.new C00121(continuation);
            }
        } else {
            c00121 = $this.new C00121(continuation);
        }
        C00121 c00122 = c00121;
        Object $result = c00122.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00122.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!StringsKt.contains$default(url, "/e/", false, 2, (Object) null)) {
                    obj = coroutine_suspended;
                    i = 0;
                    Requests app = MainActivityKt.getApp();
                    c00122.L$0 = $this;
                    c00122.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                    c00122.label = 3;
                    obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00122, 4094, (Object) null);
                    if (obj2 == obj) {
                        c00122 = c00122;
                        return obj;
                    }
                    c00122 = c00122;
                    $this2 = $this;
                    url2 = url;
                    referer2 = referer;
                    String txt = ((NiceResponse) obj2).getText();
                    matchResultFind$default2 = Regex.find$default(new Regex("file:\\s*\"(.*?m3u8.*?)\""), txt, i, 2, (Object) null);
                    if (matchResultFind$default2 != null || (groupValues2 = matchResultFind$default2.getGroupValues()) == null) {
                        str3 = null;
                    } else {
                        str3 = (String) CollectionsKt.getOrNull(groupValues2, 1);
                    }
                    String m3u8 = String.valueOf(str3);
                    String name = $this2.getName();
                    String name2 = $this2.getName();
                    ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                    C00143 c00143 = $this2.new C00143(null);
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00122.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(txt);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00122.label = 4;
                    objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name, name2, m3u8, infer_type, c00143, c00122);
                    if (objNewExtractorLink2 == obj) {
                        return obj;
                    }
                    return CollectionsKt.listOf(objNewExtractorLink2);
                }
                String newurl2 = StringsKt.replace$default(url, "/e", "", false, 4, (Object) null);
                Requests app2 = MainActivityKt.getApp();
                c00122.L$0 = $this;
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(newurl2);
                c00122.label = 1;
                obj3 = coroutine_suspended;
                str = "file:\\s*\"(.*?m3u8.*?)\"";
                i2 = 0;
                obj4 = Requests.get$default(app2, newurl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00122, 4094, (Object) null);
                if (obj4 == obj3) {
                    c00122 = c00122;
                    return obj3;
                }
                c00122 = c00122;
                $this3 = $this;
                url3 = url;
                referer3 = referer;
                newurl = newurl2;
                String txt2 = ((NiceResponse) obj4).getText();
                matchResultFind$default = Regex.find$default(new Regex(str), txt2, i2, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                    str2 = null;
                } else {
                    str2 = (String) CollectionsKt.getOrNull(groupValues, 1);
                }
                String m3u9 = String.valueOf(str2);
                String name3 = $this3.getName();
                String name4 = $this3.getName();
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                C00132 c00132 = $this3.new C00132(null);
                c00122.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(newurl);
                c00122.L$4 = SpillingKt.nullOutSpilledVariable(txt2);
                c00122.L$5 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00122.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name3, name4, m3u9, infer_type2, c00132, c00122);
                if (objNewExtractorLink == obj3) {
                    return obj3;
                }
                return CollectionsKt.listOf(objNewExtractorLink);
            case 1:
                String newurl3 = (String) c00122.L$3;
                referer3 = (String) c00122.L$2;
                url3 = (String) c00122.L$1;
                Streamruby $this4 = (Streamruby) c00122.L$0;
                ResultKt.throwOnFailure($result);
                $this3 = $this4;
                obj3 = coroutine_suspended;
                i2 = 0;
                obj4 = $result;
                str = "file:\\s*\"(.*?m3u8.*?)\"";
                newurl = newurl3;
                String txt3 = ((NiceResponse) obj4).getText();
                matchResultFind$default = Regex.find$default(new Regex(str), txt3, i2, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str2 = null;
                } else {
                    str2 = null;
                }
                String m3u10 = String.valueOf(str2);
                String name5 = $this3.getName();
                String name6 = $this3.getName();
                ExtractorLinkType infer_type3 = ExtractorApiKt.getINFER_TYPE();
                C00132 c00133 = $this3.new C00132(null);
                c00122.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(referer3);
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(newurl);
                c00122.L$4 = SpillingKt.nullOutSpilledVariable(txt3);
                c00122.L$5 = SpillingKt.nullOutSpilledVariable(m3u10);
                c00122.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, name6, m3u10, infer_type3, c00133, c00122);
                if (objNewExtractorLink == obj3) {
                    return obj3;
                }
                return CollectionsKt.listOf(objNewExtractorLink);
            case 2:
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                return CollectionsKt.listOf(objNewExtractorLink);
            case 3:
                String referer4 = (String) c00122.L$2;
                url2 = (String) c00122.L$1;
                Streamruby $this5 = (Streamruby) c00122.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this5;
                obj = coroutine_suspended;
                referer2 = referer4;
                i = 0;
                obj2 = $result;
                String txt4 = ((NiceResponse) obj2).getText();
                matchResultFind$default2 = Regex.find$default(new Regex("file:\\s*\"(.*?m3u8.*?)\""), txt4, i, 2, (Object) null);
                if (matchResultFind$default2 != null) {
                    str3 = null;
                } else {
                    str3 = null;
                }
                String m3u11 = String.valueOf(str3);
                String name7 = $this2.getName();
                String name8 = $this2.getName();
                ExtractorLinkType infer_type4 = ExtractorApiKt.getINFER_TYPE();
                C00143 c00144 = $this2.new C00143(null);
                c00122.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(txt4);
                c00122.L$4 = SpillingKt.nullOutSpilledVariable(m3u11);
                c00122.label = 4;
                objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name7, name8, m3u11, infer_type4, c00144, c00122);
                if (objNewExtractorLink2 == obj) {
                    return obj;
                }
                return CollectionsKt.listOf(objNewExtractorLink2);
            case 4:
                ResultKt.throwOnFailure($result);
                objNewExtractorLink2 = $result;
                return CollectionsKt.listOf(objNewExtractorLink2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Streamruby$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Streamruby$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00132 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00132(Continuation<? super C00132> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00132 = Streamruby.this.new C00132(continuation);
            c00132.L$0 = obj;
            return c00132;
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
                    $this$newExtractorLink.setReferer(Streamruby.this.getMainUrl());
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Streamruby$getUrl$3 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Streamruby$getUrl$3", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00143 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00143(Continuation<? super C00143> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00143 = Streamruby.this.new C00143(continuation);
            c00143.L$0 = obj;
            return c00143;
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
                    $this$newExtractorLink.setReferer(Streamruby.this.getMainUrl());
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
