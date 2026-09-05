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
import kotlin.Pair;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/phisher98/Tvlogy;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MetaData", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/Tvlogy\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,4003:1\n73#2,5:4004\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/Tvlogy\n*L\n874#1:4004,5\n*E\n"})
public final class Tvlogy extends ExtractorApi {

    @NotNull
    private final String mainUrl = "https://hls.tvlogy.to";

    @NotNull
    private final String name = "Tvlogy";
    private final boolean requiresReferer;

    /* JADX INFO: renamed from: com.phisher98.Tvlogy$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Tvlogy", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {873, 876}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "id", "data", "headers", "url", "referer", "subtitleCallback", "callback", "id", "data", "headers", "meta"}, nl = {874, 875}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C03011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C03011(Continuation<? super C03011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Tvlogy.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0167  */
    /* JADX WARN: Code duplicated, block: B:27:0x016a  */
    /* JADX WARN: Code duplicated, block: B:29:0x01bf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C03011 c03011;
        Object obj;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String id;
        Map data;
        Map data2;
        String url2;
        Object safe;
        MetaData meta;
        Function1<? super ExtractorLink, Unit> function5;
        if (continuation instanceof C03011) {
            c03011 = (C03011) continuation;
            if ((c03011.label & Integer.MIN_VALUE) != 0) {
                c03011.label -= Integer.MIN_VALUE;
            } else {
                c03011 = new C03011(continuation);
            }
        } else {
            c03011 = new C03011(continuation);
        }
        C03011 c03012 = c03011;
        Object $result = c03012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String id2 = StringsKt.substringAfter$default(url, "data=", (String) null, 2, (Object) null);
                Map data3 = MapsKt.mapOf(new Pair[]{TuplesKt.to("hash", id2), TuplesKt.to("r", "http%3A%2F%2Ftellygossips.net%2F")});
                Map headers = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                c03012.L$0 = url;
                c03012.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c03012.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c03012.L$3 = function2;
                c03012.L$4 = SpillingKt.nullOutSpilledVariable(id2);
                c03012.L$5 = SpillingKt.nullOutSpilledVariable(data3);
                c03012.L$6 = SpillingKt.nullOutSpilledVariable(headers);
                c03012.label = 1;
                obj = coroutine_suspended;
                $result = Requests.post$default(MainActivityKt.getApp(), url + "&do=getVideo", headers, url, (Map) null, (Map) null, data3, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03012, 65496, (Object) null);
                c03012 = c03012;
                if ($result == obj) {
                    return obj;
                }
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                id = id2;
                data = headers;
                data2 = data3;
                url2 = url;
                NiceResponse this_$iv = (NiceResponse) $result;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(MetaData.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                meta = (MetaData) safe;
                if (meta == null) {
                    return Unit.INSTANCE;
                }
                String name = getName();
                String name2 = getName();
                String videoSource = meta.getVideoSource();
                ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                C03022 c03022 = new C03022(url2, null);
                c03012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c03012.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c03012.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c03012.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c03012.L$4 = SpillingKt.nullOutSpilledVariable(id);
                c03012.L$5 = SpillingKt.nullOutSpilledVariable(data2);
                c03012.L$6 = SpillingKt.nullOutSpilledVariable(data);
                c03012.L$7 = SpillingKt.nullOutSpilledVariable(meta);
                c03012.L$8 = function4;
                c03012.label = 2;
                $result = ExtractorApiKt.newExtractorLink(name, name2, videoSource, extractorLinkType, c03022, c03012);
                if ($result == obj) {
                    return obj;
                }
                function5 = function4;
                function5.invoke($result);
                return Unit.INSTANCE;
            case 1:
                Map headers2 = (Map) c03012.L$6;
                Map data4 = (Map) c03012.L$5;
                String id3 = (String) c03012.L$4;
                function4 = (Function1) c03012.L$3;
                function3 = (Function1) c03012.L$2;
                referer2 = (String) c03012.L$1;
                String url3 = (String) c03012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url2 = url3;
                id = id3;
                data2 = data4;
                data = headers2;
                NiceResponse this_$iv2 = (NiceResponse) $result;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(MetaData.class));
                meta = (MetaData) safe;
                if (meta == null) {
                    return Unit.INSTANCE;
                }
                String name3 = getName();
                String name4 = getName();
                String videoSource2 = meta.getVideoSource();
                ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                C03022 c03023 = new C03022(url2, null);
                c03012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c03012.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c03012.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c03012.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c03012.L$4 = SpillingKt.nullOutSpilledVariable(id);
                c03012.L$5 = SpillingKt.nullOutSpilledVariable(data2);
                c03012.L$6 = SpillingKt.nullOutSpilledVariable(data);
                c03012.L$7 = SpillingKt.nullOutSpilledVariable(meta);
                c03012.L$8 = function4;
                c03012.label = 2;
                $result = ExtractorApiKt.newExtractorLink(name3, name4, videoSource2, extractorLinkType2, c03023, c03012);
                if ($result == obj) {
                    return obj;
                }
                function5 = function4;
                function5.invoke($result);
                return Unit.INSTANCE;
            case 2:
                function5 = (Function1) c03012.L$8;
                ResultKt.throwOnFailure($result);
                function5.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Tvlogy$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Tvlogy$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C03022 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03022(String str, Continuation<? super C03022> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c03022 = new C03022(this.$url, continuation);
            c03022.L$0 = obj;
            return c03022;
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

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/phisher98/Tvlogy$MetaData;", "", "hls", "", "videoSource", "", "<init>", "(ZLjava/lang/String;)V", "getHls", "()Z", "getVideoSource", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class MetaData {
        private final boolean hls;

        @NotNull
        private final String videoSource;

        public static /* synthetic */ MetaData copy$default(MetaData metaData, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = metaData.hls;
            }
            if ((i & 2) != 0) {
                str = metaData.videoSource;
            }
            return metaData.copy(z, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getHls() {
            return this.hls;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getVideoSource() {
            return this.videoSource;
        }

        @NotNull
        public final MetaData copy(boolean hls, @NotNull String videoSource) {
            return new MetaData(hls, videoSource);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MetaData)) {
                return false;
            }
            MetaData metaData = (MetaData) other;
            return this.hls == metaData.hls && Intrinsics.areEqual(this.videoSource, metaData.videoSource);
        }

        public int hashCode() {
            return (Tvlogy$MetaData$$ExternalSyntheticBackport0.m34m(this.hls) * 31) + this.videoSource.hashCode();
        }

        @NotNull
        public String toString() {
            return "MetaData(hls=" + this.hls + ", videoSource=" + this.videoSource + ')';
        }

        public MetaData(boolean hls, @NotNull String videoSource) {
            this.hls = hls;
            this.videoSource = videoSource;
        }

        public final boolean getHls() {
            return this.hls;
        }

        @NotNull
        public final String getVideoSource() {
            return this.videoSource;
        }
    }
}
