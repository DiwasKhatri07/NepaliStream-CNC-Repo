package com.fourKHDHub;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
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
import kotlin.Result;
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

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/FourKHDHub/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/fourKHDHub/Hubcdnn;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FourKHDHub"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Hubcdnn extends ExtractorApi {

    @NotNull
    private final String name = "Hubcdn";

    @NotNull
    private final String mainUrl = "https://hubcdn.*";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.fourKHDHub.Hubcdnn$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.Hubcdnn", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {96, 121}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "$this$getUrl_u24lambda_u240", "url", "referer", "subtitleCallback", "callback", "html", "encoded", "m3u8"}, nl = {95, 120}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00141 extends ContinuationImpl {
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

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Hubcdnn.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:41:0x012d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0146  */
    /* JADX WARN: Code duplicated, block: B:47:0x0157 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:50:0x015b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0167  */
    /* JADX WARN: Code duplicated, block: B:55:0x016a  */
    /* JADX WARN: Code duplicated, block: B:63:0x019f  */
    /* JADX WARN: Code duplicated, block: B:65:0x01f0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:69:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:71:0x020e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:83:0x0178 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:41:0x012d, please report this as an issue */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00141 c00141;
        Object obj;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object obj2;
        String url3;
        String url4;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        Throwable it;
        String html;
        String str;
        String encoded;
        Object obj3;
        Function1<? super ExtractorLink, Unit> function7;
        List groupValues;
        if (continuation instanceof C00141) {
            c00141 = (C00141) continuation;
            if ((c00141.label & Integer.MIN_VALUE) != 0) {
                c00141.label -= Integer.MIN_VALUE;
            } else {
                c00141 = new C00141(continuation);
            }
        } else {
            c00141 = new C00141(continuation);
        }
        C00141 c00142 = c00141;
        Object $result = c00142.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00142.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Result.Companion companion = Result.Companion;
                    Hubcdnn $this$getUrl_u24lambda_u240 = this;
                    try {
                        Requests app = MainActivityKt.getApp();
                        c00142.L$0 = url;
                        c00142.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                        c00142.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                        c00142.L$3 = function2;
                        c00142.L$4 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u240);
                        c00142.label = 1;
                        obj = coroutine_suspended;
                        try {
                            $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 4094, (Object) null);
                            c00142 = c00142;
                            if ($result == obj) {
                                return obj;
                            }
                            url2 = url;
                            referer2 = referer;
                            function3 = function1;
                            function4 = function2;
                            try {
                                obj2 = Result.constructor-impl(((NiceResponse) $result).getDocument().toString());
                                break;
                            } catch (Throwable th) {
                                th = th;
                                Object $result2 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            url3 = url2;
                            url4 = referer2;
                            function5 = function3;
                            function6 = function4;
                            it = Result.exceptionOrNull-impl(obj2);
                            if (it == null) {
                                Log.INSTANCE.e(getName(), "Failed to load page: " + it.getMessage());
                                return Unit.INSTANCE;
                            }
                            html = (String) obj2;
                            MatchResult matchResultFind$default = Regex.find$default(new Regex("r=([A-Za-z0-9+/=]+)"), html, 0, 2, (Object) null);
                            str = (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues, 1);
                            if (str == null) {
                                str = "";
                            }
                            encoded = str;
                            if (encoded.length() == 0) {
                                Log.INSTANCE.e(getName(), "Encoded URL not found");
                                return Unit.INSTANCE;
                            }
                            try {
                                Result.Companion companion2 = Result.Companion;
                                Hubcdnn hubcdnn = this;
                                obj3 = Result.constructor-impl(StringsKt.substringAfterLast$default(MainAPIKt.base64Decode(encoded), "link=", (String) null, 2, (Object) null));
                                break;
                            } catch (Throwable th2) {
                                Result.Companion companion3 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th2));
                            }
                            if (Result.exceptionOrNull-impl(obj3) == null) {
                                Log.INSTANCE.e(getName(), "Failed to decode base64");
                                return Unit.INSTANCE;
                            }
                            String m3u8 = (String) obj3;
                            String name = getName();
                            String name2 = getName();
                            ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                            C00152 c00152 = new C00152(url3, null);
                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(html);
                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(encoded);
                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(m3u8);
                            c00142.L$7 = function6;
                            c00142.label = 2;
                            $result = ExtractorApiKt.newExtractorLink(name, name2, m3u8, extractorLinkType, c00152, c00142);
                            if ($result == obj) {
                                return obj;
                            }
                            function7 = function6;
                            function7.invoke($result);
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            th = th3;
                            c00142 = c00142;
                            url2 = url;
                            referer2 = referer;
                            function3 = function1;
                            function4 = function2;
                            Object $result3 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            url3 = url2;
                            url4 = referer2;
                            function5 = function3;
                            function6 = function4;
                            it = Result.exceptionOrNull-impl(obj2);
                            if (it == null) {
                                Log.INSTANCE.e(getName(), "Failed to load page: " + it.getMessage());
                                return Unit.INSTANCE;
                            }
                            html = (String) obj2;
                            MatchResult matchResultFind$default2 = Regex.find$default(new Regex("r=([A-Za-z0-9+/=]+)"), html, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                            }
                            if (str == null) {
                                str = "";
                            }
                            encoded = str;
                            if (encoded.length() == 0) {
                                Log.INSTANCE.e(getName(), "Encoded URL not found");
                                return Unit.INSTANCE;
                            }
                            Result.Companion companion4 = Result.Companion;
                            Hubcdnn hubcdnn2 = this;
                            obj3 = Result.constructor-impl(StringsKt.substringAfterLast$default(MainAPIKt.base64Decode(encoded), "link=", (String) null, 2, (Object) null));
                            if (Result.exceptionOrNull-impl(obj3) == null) {
                                Log.INSTANCE.e(getName(), "Failed to decode base64");
                                return Unit.INSTANCE;
                            }
                            String m3u9 = (String) obj3;
                            String name3 = getName();
                            String name4 = getName();
                            ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                            C00152 c00153 = new C00152(url3, null);
                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(html);
                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(encoded);
                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(m3u9);
                            c00142.L$7 = function6;
                            c00142.label = 2;
                            $result = ExtractorApiKt.newExtractorLink(name3, name4, m3u9, extractorLinkType2, c00153, c00142);
                            if ($result == obj) {
                                return obj;
                            }
                            function7 = function6;
                            function7.invoke($result);
                            return Unit.INSTANCE;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        obj = coroutine_suspended;
                        url2 = url;
                        referer2 = referer;
                        function3 = function1;
                        function4 = function2;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    obj = coroutine_suspended;
                    url2 = url;
                    referer2 = referer;
                    function3 = function1;
                    function4 = function2;
                }
                break;
            case 1:
                function4 = (Function1) c00142.L$3;
                function3 = (Function1) c00142.L$2;
                referer2 = (String) c00142.L$1;
                url2 = (String) c00142.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = coroutine_suspended;
                    obj2 = Result.constructor-impl(((NiceResponse) $result).getDocument().toString());
                    break;
                } catch (Throwable th6) {
                    th = th6;
                    obj = coroutine_suspended;
                    Object $result4 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    url3 = url2;
                    url4 = referer2;
                    function5 = function3;
                    function6 = function4;
                    it = Result.exceptionOrNull-impl(obj2);
                    if (it == null) {
                        Log.INSTANCE.e(getName(), "Failed to load page: " + it.getMessage());
                        return Unit.INSTANCE;
                    }
                    html = (String) obj2;
                    MatchResult matchResultFind$default3 = Regex.find$default(new Regex("r=([A-Za-z0-9+/=]+)"), html, 0, 2, (Object) null);
                    if (matchResultFind$default3 != null) {
                    }
                    if (str == null) {
                        str = "";
                    }
                    encoded = str;
                    if (encoded.length() == 0) {
                        Log.INSTANCE.e(getName(), "Encoded URL not found");
                        return Unit.INSTANCE;
                    }
                    Result.Companion companion5 = Result.Companion;
                    Hubcdnn hubcdnn3 = this;
                    obj3 = Result.constructor-impl(StringsKt.substringAfterLast$default(MainAPIKt.base64Decode(encoded), "link=", (String) null, 2, (Object) null));
                    if (Result.exceptionOrNull-impl(obj3) == null) {
                        Log.INSTANCE.e(getName(), "Failed to decode base64");
                        return Unit.INSTANCE;
                    }
                    String m3u10 = (String) obj3;
                    String name5 = getName();
                    String name6 = getName();
                    ExtractorLinkType extractorLinkType3 = ExtractorLinkType.M3U8;
                    C00152 c00154 = new C00152(url3, null);
                    c00142.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00142.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                    c00142.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                    c00142.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                    c00142.L$4 = SpillingKt.nullOutSpilledVariable(html);
                    c00142.L$5 = SpillingKt.nullOutSpilledVariable(encoded);
                    c00142.L$6 = SpillingKt.nullOutSpilledVariable(m3u10);
                    c00142.L$7 = function6;
                    c00142.label = 2;
                    $result = ExtractorApiKt.newExtractorLink(name5, name6, m3u10, extractorLinkType3, c00154, c00142);
                    if ($result == obj) {
                        return obj;
                    }
                    function7 = function6;
                    function7.invoke($result);
                    return Unit.INSTANCE;
                }
                url3 = url2;
                url4 = referer2;
                function5 = function3;
                function6 = function4;
                it = Result.exceptionOrNull-impl(obj2);
                if (it == null) {
                    Log.INSTANCE.e(getName(), "Failed to load page: " + it.getMessage());
                    return Unit.INSTANCE;
                }
                html = (String) obj2;
                MatchResult matchResultFind$default4 = Regex.find$default(new Regex("r=([A-Za-z0-9+/=]+)"), html, 0, 2, (Object) null);
                if (matchResultFind$default4 != null) {
                }
                if (str == null) {
                    str = "";
                }
                encoded = str;
                if (encoded.length() == 0) {
                    Log.INSTANCE.e(getName(), "Encoded URL not found");
                    return Unit.INSTANCE;
                }
                Result.Companion companion6 = Result.Companion;
                Hubcdnn hubcdnn4 = this;
                obj3 = Result.constructor-impl(StringsKt.substringAfterLast$default(MainAPIKt.base64Decode(encoded), "link=", (String) null, 2, (Object) null));
                if (Result.exceptionOrNull-impl(obj3) == null) {
                    Log.INSTANCE.e(getName(), "Failed to decode base64");
                    return Unit.INSTANCE;
                }
                String m3u11 = (String) obj3;
                String name7 = getName();
                String name8 = getName();
                ExtractorLinkType extractorLinkType4 = ExtractorLinkType.M3U8;
                C00152 c00155 = new C00152(url3, null);
                c00142.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00142.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                c00142.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                c00142.L$4 = SpillingKt.nullOutSpilledVariable(html);
                c00142.L$5 = SpillingKt.nullOutSpilledVariable(encoded);
                c00142.L$6 = SpillingKt.nullOutSpilledVariable(m3u11);
                c00142.L$7 = function6;
                c00142.label = 2;
                $result = ExtractorApiKt.newExtractorLink(name7, name8, m3u11, extractorLinkType4, c00155, c00142);
                if ($result == obj) {
                    return obj;
                }
                function7 = function6;
                function7.invoke($result);
                return Unit.INSTANCE;
            case 2:
                function7 = (Function1) c00142.L$7;
                ResultKt.throwOnFailure($result);
                function7.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.fourKHDHub.Hubcdnn$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.Hubcdnn$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00152 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00152(String str, Continuation<? super C00152> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00152 = new C00152(this.$url, continuation);
            c00152.L$0 = obj;
            return c00152;
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
