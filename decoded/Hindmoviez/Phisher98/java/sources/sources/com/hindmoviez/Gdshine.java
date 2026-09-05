package com.hindmoviez;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
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

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Hindmoviez/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/hindmoviez/Gdshine;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Response", "Data", "Worker", "WorkerData", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/hindmoviez/Gdshine\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,58:1\n73#2,5:59\n73#2,5:64\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/hindmoviez/Gdshine\n*L\n24#1:59,5\n28#1:64,5\n*E\n"})
public final class Gdshine extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Gdshine";

    @NotNull
    private final String mainUrl = "https://gdshine.org";

    /* JADX INFO: renamed from: com.hindmoviez.Gdshine$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hindmoviez.Gdshine", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {23, 27, 32}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "id", "url", "referer", "subtitleCallback", "callback", "id", "fileData", "url", "referer", "subtitleCallback", "callback", "id", "fileData", "workerData"}, nl = {24, 28, 31}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Gdshine.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00001 c00001;
        Gdshine gdshine;
        Object obj;
        int i;
        String url2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String id;
        Object obj2;
        String referer2;
        Object safe;
        Response response;
        Data fileData;
        Function1<? super ExtractorLink, Unit> function5;
        String referer3;
        Data fileData2;
        Object safe2;
        Worker worker;
        WorkerData workerData;
        Function1<? super ExtractorLink, Unit> function6;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
                gdshine = this;
            } else {
                gdshine = this;
                c00001 = gdshine.new C00001(continuation);
            }
        } else {
            gdshine = this;
            c00001 = gdshine.new C00001(continuation);
        }
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String id2 = StringsKt.substringAfterLast$default(url, '/', (String) null, 2, (Object) null);
                Requests app = MainActivityKt.getApp();
                String str = gdshine.getMainUrl() + "/api/files/s/" + id2;
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00002.L$1 = referer;
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00002.L$3 = function2;
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(id2);
                c00002.label = 1;
                obj = coroutine_suspended;
                i = 2;
                Object obj3 = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                c00002 = c00002;
                if (obj3 == obj) {
                    return obj;
                }
                url2 = url;
                function3 = function1;
                function4 = function2;
                id = id2;
                obj2 = obj3;
                referer2 = referer;
                NiceResponse this_$iv = (NiceResponse) obj2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Response.class));
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                response = (Response) safe;
                if (response != null || (fileData = response.getData()) == null) {
                    return Unit.INSTANCE;
                }
                Requests app2 = MainActivityKt.getApp();
                String str2 = getMainUrl() + "/api/downloads/" + fileData.getId() + "/via-worker";
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00002.L$1 = referer2;
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$3 = function4;
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(id);
                c00002.L$5 = fileData;
                c00002.label = i;
                String referer4 = referer2;
                function5 = function4;
                C00001 c00003 = c00002;
                $result = Requests.post$default(app2, str2, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00003, 65534, (Object) null);
                c00002 = c00003;
                if ($result == obj) {
                    return obj;
                }
                referer3 = referer4;
                fileData2 = fileData;
                NiceResponse this_$iv2 = (NiceResponse) $result;
                try {
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Worker.class));
                    break;
                } catch (Exception e$iv2) {
                    e$iv2.printStackTrace();
                    safe2 = null;
                }
                worker = (Worker) safe2;
                if (worker != null || (workerData = worker.getData()) == null) {
                    return Unit.INSTANCE;
                }
                String copyUrl = workerData.getCopyUrl();
                C00012 c00012 = new C00012(fileData2, null);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function5);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(id);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(fileData2);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(workerData);
                c00002.L$7 = function5;
                c00002.label = 3;
                $result = ExtractorApiKt.newExtractorLink$default(getName(), "[Gdshine] " + referer3, copyUrl, (ExtractorLinkType) null, c00012, c00002, 8, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                function6 = function5;
                function6.invoke($result);
                return Unit.INSTANCE;
            case 1:
                String id3 = (String) c00002.L$4;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00002.L$3;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c00002.L$2;
                String referer5 = (String) c00002.L$1;
                String url3 = (String) c00002.L$0;
                ResultKt.throwOnFailure($result);
                id = id3;
                obj2 = $result;
                obj = coroutine_suspended;
                function4 = function7;
                function3 = function8;
                referer2 = referer5;
                url2 = url3;
                i = 2;
                NiceResponse this_$iv3 = (NiceResponse) obj2;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(Response.class));
                response = (Response) safe;
                if (response != null) {
                }
                return Unit.INSTANCE;
            case 2:
                Data fileData3 = (Data) c00002.L$5;
                String id4 = (String) c00002.L$4;
                Function1<? super ExtractorLink, Unit> function9 = (Function1) c00002.L$3;
                Function1<? super SubtitleFile, Unit> function10 = (Function1) c00002.L$2;
                String referer6 = (String) c00002.L$1;
                String url4 = (String) c00002.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                id = id4;
                function5 = function9;
                function3 = function10;
                referer3 = referer6;
                url2 = url4;
                fileData2 = fileData3;
                NiceResponse this_$iv4 = (NiceResponse) $result;
                ResponseParser parser4 = this_$iv4.getParser();
                Intrinsics.checkNotNull(parser4);
                safe2 = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(Worker.class));
                worker = (Worker) safe2;
                if (worker != null) {
                }
                return Unit.INSTANCE;
            case 3:
                function6 = (Function1) c00002.L$7;
                ResultKt.throwOnFailure($result);
                function6.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.hindmoviez.Gdshine$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hindmoviez.Gdshine$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00012 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Data $fileData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00012(Data data, Continuation<? super C00012> continuation) {
            super(2, continuation);
            this.$fileData = data;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00012 = new C00012(this.$fileData, continuation);
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
                    $this$newExtractorLink.setQuality(UtilsKt.getIndexQuality(this.$fileData.getName()));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/hindmoviez/Gdshine$Response;", "", "data", "Lcom/hindmoviez/Gdshine$Data;", "<init>", "(Lcom/hindmoviez/Gdshine$Data;)V", "getData", "()Lcom/hindmoviez/Gdshine$Data;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Response {

        @NotNull
        private final Data data;

        public static /* synthetic */ Response copy$default(Response response, Data data, int i, Object obj) {
            if ((i & 1) != 0) {
                data = response.data;
            }
            return response.copy(data);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Data getData() {
            return this.data;
        }

        @NotNull
        public final Response copy(@NotNull Data data) {
            return new Response(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Response) && Intrinsics.areEqual(this.data, ((Response) other).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "Response(data=" + this.data + ')';
        }

        public Response(@NotNull Data data) {
            this.data = data;
        }

        @NotNull
        public final Data getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/hindmoviez/Gdshine$Data;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Data {

        @NotNull
        private final String id;

        @NotNull
        private final String name;

        public static /* synthetic */ Data copy$default(Data data, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.id;
            }
            if ((i & 2) != 0) {
                str2 = data.name;
            }
            return data.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final Data copy(@NotNull String id, @NotNull String name) {
            return new Data(id, name);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.id, data.id) && Intrinsics.areEqual(this.name, data.name);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.name.hashCode();
        }

        @NotNull
        public String toString() {
            return "Data(id=" + this.id + ", name=" + this.name + ')';
        }

        public Data(@NotNull String id, @NotNull String name) {
            this.id = id;
            this.name = name;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/hindmoviez/Gdshine$Worker;", "", "data", "Lcom/hindmoviez/Gdshine$WorkerData;", "<init>", "(Lcom/hindmoviez/Gdshine$WorkerData;)V", "getData", "()Lcom/hindmoviez/Gdshine$WorkerData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Worker {

        @NotNull
        private final WorkerData data;

        public static /* synthetic */ Worker copy$default(Worker worker, WorkerData workerData, int i, Object obj) {
            if ((i & 1) != 0) {
                workerData = worker.data;
            }
            return worker.copy(workerData);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final WorkerData getData() {
            return this.data;
        }

        @NotNull
        public final Worker copy(@NotNull WorkerData data) {
            return new Worker(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Worker) && Intrinsics.areEqual(this.data, ((Worker) other).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "Worker(data=" + this.data + ')';
        }

        public Worker(@NotNull WorkerData data) {
            this.data = data;
        }

        @NotNull
        public final WorkerData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/hindmoviez/Gdshine$WorkerData;", "", "copyUrl", "", "<init>", "(Ljava/lang/String;)V", "getCopyUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class WorkerData {

        @NotNull
        private final String copyUrl;

        public static /* synthetic */ WorkerData copy$default(WorkerData workerData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = workerData.copyUrl;
            }
            return workerData.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCopyUrl() {
            return this.copyUrl;
        }

        @NotNull
        public final WorkerData copy(@NotNull String copyUrl) {
            return new WorkerData(copyUrl);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WorkerData) && Intrinsics.areEqual(this.copyUrl, ((WorkerData) other).copyUrl);
        }

        public int hashCode() {
            return this.copyUrl.hashCode();
        }

        @NotNull
        public String toString() {
            return "WorkerData(copyUrl=" + this.copyUrl + ')';
        }

        public WorkerData(@NotNull String copyUrl) {
            this.copyUrl = copyUrl;
        }

        @NotNull
        public final String getCopyUrl() {
            return this.copyUrl;
        }
    }
}
