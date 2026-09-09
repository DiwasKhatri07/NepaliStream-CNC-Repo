package com.phisher98;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamKitsuHelper.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u001a\u001b\u001c\u001d\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J8\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/phisher98/TorraStreamKitsuHelper;", "", "<init>", "()V", "KITSU_BASE_URL", "", "mapSectionToKitsuCatalog", "sectionName", "getCatalog", "Lkotlin/Pair;", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "", "api", "Lcom/lagradost/cloudstream3/MainAPI;", "catalogId", "page", "", "(Lcom/lagradost/cloudstream3/MainAPI;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "query", "(Lcom/lagradost/cloudstream3/MainAPI;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMeta", "Lcom/phisher98/TorraStreamKitsuHelper$KitsuMeta;", "idWithPrefix", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "KitsuCatalogResponse", "KitsuMetaResponse", "KitsuMeta", "KitsuVideo", "KitsuLink", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTorraStreamKitsuHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamKitsuHelper.kt\ncom/phisher98/TorraStreamKitsuHelper\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,139:1\n73#2,5:140\n73#2,5:149\n73#2,5:158\n1739#3:145\n1814#3,3:146\n1739#3:154\n1814#3,3:155\n*S KotlinDebug\n*F\n+ 1 TorraStreamKitsuHelper.kt\ncom/phisher98/TorraStreamKitsuHelper\n*L\n113#1:140,5\n122#1:149,5\n136#1:158,5\n114#1:145\n114#1:146,3\n123#1:154\n123#1:155,3\n*E\n"})
public final class TorraStreamKitsuHelper {

    @NotNull
    public static final TorraStreamKitsuHelper INSTANCE = new TorraStreamKitsuHelper();

    @NotNull
    public static final String KITSU_BASE_URL = "https://anime-kitsu.strem.fun";

    /* JADX INFO: renamed from: com.phisher98.TorraStreamKitsuHelper$getCatalog$1 */
    /* JADX INFO: compiled from: TorraStreamKitsuHelper.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamKitsuHelper", f = "TorraStreamKitsuHelper.kt", i = {0, 0, 0, 0, 0}, l = {113}, m = "getCatalog", n = {"api", "catalogId", "url", "page", "skip"}, nl = {140}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 2)
    static final class C00621 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00621(Continuation<? super C00621> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamKitsuHelper.this.getCatalog(null, null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamKitsuHelper$getMeta$1 */
    /* JADX INFO: compiled from: TorraStreamKitsuHelper.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamKitsuHelper", f = "TorraStreamKitsuHelper.kt", i = {0, 0, 0}, l = {136}, m = "getMeta", n = {"idWithPrefix", "formattedId", "url"}, nl = {140}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00631 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00631(Continuation<? super C00631> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamKitsuHelper.this.getMeta(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamKitsuHelper$search$1 */
    /* JADX INFO: compiled from: TorraStreamKitsuHelper.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamKitsuHelper", f = "TorraStreamKitsuHelper.kt", i = {0, 0, 0, 0}, l = {122}, m = "search", n = {"api", "query", "encoded", "url"}, nl = {140}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00641 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00641(Continuation<? super C00641> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamKitsuHelper.this.search(null, null, (Continuation) this);
        }
    }

    private TorraStreamKitsuHelper() {
    }

    /* JADX INFO: compiled from: TorraStreamKitsuHelper.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nÊ\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/phisher98/TorraStreamKitsuHelper$KitsuCatalogResponse;", "", "metas", "", "Lcom/phisher98/TorraStreamKitsuHelper$KitsuMeta;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/List;)V", "getMetas", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TorraStream", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class KitsuCatalogResponse {

        @NotNull
        private final List<KitsuMeta> metas;

        /* JADX WARN: Illegal instructions before constructor call */
        public KitsuCatalogResponse() {
            List list = null;
            this(list, 1, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ KitsuCatalogResponse copy$default(KitsuCatalogResponse kitsuCatalogResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = kitsuCatalogResponse.metas;
            }
            return kitsuCatalogResponse.copy(list);
        }

        @NotNull
        public final List<KitsuMeta> component1() {
            return this.metas;
        }

        @NotNull
        public final KitsuCatalogResponse copy(@JsonProperty("metas") @NotNull List<KitsuMeta> metas) {
            return new KitsuCatalogResponse(metas);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof KitsuCatalogResponse) && Intrinsics.areEqual(this.metas, ((KitsuCatalogResponse) other).metas);
        }

        public int hashCode() {
            return this.metas.hashCode();
        }

        @NotNull
        public String toString() {
            return "KitsuCatalogResponse(metas=" + this.metas + ')';
        }

        public KitsuCatalogResponse(@JsonProperty("metas") @NotNull List<KitsuMeta> list) {
            this.metas = list;
        }

        public /* synthetic */ KitsuCatalogResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
        }

        @NotNull
        public final List<KitsuMeta> getMetas() {
            return this.metas;
        }
    }

    /* JADX INFO: compiled from: TorraStreamKitsuHelper.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tÊ\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u0013"}, d2 = {"Lcom/phisher98/TorraStreamKitsuHelper$KitsuMetaResponse;", "", "meta", "Lcom/phisher98/TorraStreamKitsuHelper$KitsuMeta;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/TorraStreamKitsuHelper$KitsuMeta;)V", "getMeta", "()Lcom/phisher98/TorraStreamKitsuHelper$KitsuMeta;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TorraStream", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class KitsuMetaResponse {

        @Nullable
        private final KitsuMeta meta;

        /* JADX WARN: Illegal instructions before constructor call */
        public KitsuMetaResponse() {
            KitsuMeta kitsuMeta = null;
            this(kitsuMeta, 1, kitsuMeta);
        }

        public static /* synthetic */ KitsuMetaResponse copy$default(KitsuMetaResponse kitsuMetaResponse, KitsuMeta kitsuMeta, int i, Object obj) {
            if ((i & 1) != 0) {
                kitsuMeta = kitsuMetaResponse.meta;
            }
            return kitsuMetaResponse.copy(kitsuMeta);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final KitsuMeta getMeta() {
            return this.meta;
        }

        @NotNull
        public final KitsuMetaResponse copy(@JsonProperty("meta") @Nullable KitsuMeta meta) {
            return new KitsuMetaResponse(meta);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof KitsuMetaResponse) && Intrinsics.areEqual(this.meta, ((KitsuMetaResponse) other).meta);
        }

        public int hashCode() {
            if (this.meta == null) {
                return 0;
            }
            return this.meta.hashCode();
        }

        @NotNull
        public String toString() {
            return "KitsuMetaResponse(meta=" + this.meta + ')';
        }

        public KitsuMetaResponse(@JsonProperty("meta") @Nullable KitsuMeta meta) {
            this.meta = meta;
        }

        public /* synthetic */ KitsuMetaResponse(KitsuMeta kitsuMeta, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : kitsuMeta);
        }

        @Nullable
        public final KitsuMeta getMeta() {
            return this.meta;
        }
    }

    /* JADX INFO: compiled from: TorraStreamKitsuHelper.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bñ\u0003\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u001e\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u001e\b\u0003\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u001e\b\u0003\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u001e\b\u0003\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u00102\u001a\u0004\u0018\u000103¢\u0006\u0002\u00104J\r\u00105\u001a\u0004\u0018\u000103¢\u0006\u0002\u00104J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u000209J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000eHÆ\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000eHÆ\u0003Jó\u0003\u0010L\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u001e\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u001e\b\u0003\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00132\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00162\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u001e\b\u0003\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u001e\b\u0003\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001aHÆ\u0001J\u0014\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010P\u001a\u000203HÖ\u0081\u0004J\n\u0010Q\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&Ê\u0001\f\bS\u0012\b\bT\u0012\u0004\b\u0007\u0010\u0002¨\u0006R"}, d2 = {"Lcom/phisher98/TorraStreamKitsuHelper$KitsuMeta;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "kitsuId", "kitsu_id", "imdbId", "imdb_id", "type", "animeType", "name", "aliases", "", "description", "releaseInfo", "year", "imdbRating", "genres", "logo", "poster", "background", "status", "videos", "Lcom/phisher98/TorraStreamKitsuHelper$KitsuVideo;", "links", "Lcom/phisher98/TorraStreamKitsuHelper$KitsuLink;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getKitsuId", "getImdbId", "getType", "getAnimeType", "getName", "getAliases", "()Ljava/util/List;", "getDescription", "getReleaseInfo", "getYear", "getImdbRating", "getGenres", "getLogo", "getPoster", "getBackground", "getStatus", "getVideos", "getLinks", "getNumericKitsuId", "", "()Ljava/lang/Integer;", "getYearInt", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "api", "Lcom/lagradost/cloudstream3/MainAPI;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "", "other", "hashCode", "toString", "TorraStream", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nTorraStreamKitsuHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamKitsuHelper.kt\ncom/phisher98/TorraStreamKitsuHelper$KitsuMeta\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n1#2:140\n*E\n"})
    public static final /* data */ class KitsuMeta {

        @Nullable
        private final List<String> aliases;

        @Nullable
        private final String animeType;

        @Nullable
        private final String background;

        @Nullable
        private final String description;

        @Nullable
        private final List<String> genres;

        @NotNull
        private final String id;

        @Nullable
        private final String imdbId;

        @Nullable
        private final String imdbRating;

        @Nullable
        private final String kitsuId;

        @Nullable
        private final List<KitsuLink> links;

        @Nullable
        private final String logo;

        @Nullable
        private final String name;

        @Nullable
        private final String poster;

        @Nullable
        private final String releaseInfo;

        @Nullable
        private final String status;

        @Nullable
        private final String type;

        @Nullable
        private final List<KitsuVideo> videos;

        @Nullable
        private final String year;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ KitsuMeta copy$default(KitsuMeta kitsuMeta, String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, String str8, String str9, String str10, List list2, String str11, String str12, String str13, String str14, List list3, List list4, int i, Object obj) {
            List list5;
            List list6;
            String str15 = (i & 1) != 0 ? kitsuMeta.id : str;
            String str16 = (i & 2) != 0 ? kitsuMeta.kitsuId : str2;
            String str17 = (i & 4) != 0 ? kitsuMeta.imdbId : str3;
            String str18 = (i & 8) != 0 ? kitsuMeta.type : str4;
            String str19 = (i & 16) != 0 ? kitsuMeta.animeType : str5;
            String str20 = (i & 32) != 0 ? kitsuMeta.name : str6;
            List list7 = (i & 64) != 0 ? kitsuMeta.aliases : list;
            String str21 = (i & 128) != 0 ? kitsuMeta.description : str7;
            String str22 = (i & 256) != 0 ? kitsuMeta.releaseInfo : str8;
            String str23 = (i & 512) != 0 ? kitsuMeta.year : str9;
            String str24 = (i & 1024) != 0 ? kitsuMeta.imdbRating : str10;
            List list8 = (i & 2048) != 0 ? kitsuMeta.genres : list2;
            String str25 = (i & 4096) != 0 ? kitsuMeta.logo : str11;
            String str26 = (i & 8192) != 0 ? kitsuMeta.poster : str12;
            String str27 = str15;
            String str28 = (i & 16384) != 0 ? kitsuMeta.background : str13;
            String str29 = (i & 32768) != 0 ? kitsuMeta.status : str14;
            List list9 = (i & 65536) != 0 ? kitsuMeta.videos : list3;
            if ((i & 131072) != 0) {
                list6 = list9;
                list5 = kitsuMeta.links;
            } else {
                list5 = list4;
                list6 = list9;
            }
            return kitsuMeta.copy(str27, str16, str17, str18, str19, str20, list7, str21, str22, str23, str24, list8, str25, str26, str28, str29, list6, list5);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final List<String> component12() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getLogo() {
            return this.logo;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getBackground() {
            return this.background;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final List<KitsuVideo> component17() {
            return this.videos;
        }

        @Nullable
        public final List<KitsuLink> component18() {
            return this.links;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getKitsuId() {
            return this.kitsuId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAnimeType() {
            return this.animeType;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final List<String> component7() {
            return this.aliases;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getReleaseInfo() {
            return this.releaseInfo;
        }

        @NotNull
        public final KitsuMeta copy(@JsonProperty("id") @NotNull String id, @JsonProperty("kitsu_id") @Nullable String kitsuId, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("type") @Nullable String type, @JsonProperty("animeType") @Nullable String animeType, @JsonProperty("name") @Nullable String name, @JsonProperty("aliases") @Nullable List<String> aliases, @JsonProperty("description") @Nullable String description, @JsonProperty("releaseInfo") @Nullable String releaseInfo, @JsonProperty("year") @Nullable String year, @JsonProperty("imdbRating") @Nullable String imdbRating, @JsonProperty("genres") @Nullable List<String> genres, @JsonProperty("logo") @Nullable String logo, @JsonProperty("poster") @Nullable String poster, @JsonProperty("background") @Nullable String background, @JsonProperty("status") @Nullable String status, @JsonProperty("videos") @Nullable List<KitsuVideo> videos, @JsonProperty("links") @Nullable List<KitsuLink> links) {
            return new KitsuMeta(id, kitsuId, imdbId, type, animeType, name, aliases, description, releaseInfo, year, imdbRating, genres, logo, poster, background, status, videos, links);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof KitsuMeta)) {
                return false;
            }
            KitsuMeta kitsuMeta = (KitsuMeta) other;
            return Intrinsics.areEqual(this.id, kitsuMeta.id) && Intrinsics.areEqual(this.kitsuId, kitsuMeta.kitsuId) && Intrinsics.areEqual(this.imdbId, kitsuMeta.imdbId) && Intrinsics.areEqual(this.type, kitsuMeta.type) && Intrinsics.areEqual(this.animeType, kitsuMeta.animeType) && Intrinsics.areEqual(this.name, kitsuMeta.name) && Intrinsics.areEqual(this.aliases, kitsuMeta.aliases) && Intrinsics.areEqual(this.description, kitsuMeta.description) && Intrinsics.areEqual(this.releaseInfo, kitsuMeta.releaseInfo) && Intrinsics.areEqual(this.year, kitsuMeta.year) && Intrinsics.areEqual(this.imdbRating, kitsuMeta.imdbRating) && Intrinsics.areEqual(this.genres, kitsuMeta.genres) && Intrinsics.areEqual(this.logo, kitsuMeta.logo) && Intrinsics.areEqual(this.poster, kitsuMeta.poster) && Intrinsics.areEqual(this.background, kitsuMeta.background) && Intrinsics.areEqual(this.status, kitsuMeta.status) && Intrinsics.areEqual(this.videos, kitsuMeta.videos) && Intrinsics.areEqual(this.links, kitsuMeta.links);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((this.id.hashCode() * 31) + (this.kitsuId == null ? 0 : this.kitsuId.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.animeType == null ? 0 : this.animeType.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.aliases == null ? 0 : this.aliases.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.releaseInfo == null ? 0 : this.releaseInfo.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.logo == null ? 0 : this.logo.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.background == null ? 0 : this.background.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.videos == null ? 0 : this.videos.hashCode())) * 31) + (this.links != null ? this.links.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("KitsuMeta(id=").append(this.id).append(", kitsuId=").append(this.kitsuId).append(", imdbId=").append(this.imdbId).append(", type=").append(this.type).append(", animeType=").append(this.animeType).append(", name=").append(this.name).append(", aliases=").append(this.aliases).append(", description=").append(this.description).append(", releaseInfo=").append(this.releaseInfo).append(", year=").append(this.year).append(", imdbRating=").append(this.imdbRating).append(", genres=");
            sb.append(this.genres).append(", logo=").append(this.logo).append(", poster=").append(this.poster).append(", background=").append(this.background).append(", status=").append(this.status).append(", videos=").append(this.videos).append(", links=").append(this.links).append(')');
            return sb.toString();
        }

        public KitsuMeta(@JsonProperty("id") @NotNull String id, @JsonProperty("kitsu_id") @Nullable String kitsuId, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("type") @Nullable String type, @JsonProperty("animeType") @Nullable String animeType, @JsonProperty("name") @Nullable String name, @JsonProperty("aliases") @Nullable List<String> list, @JsonProperty("description") @Nullable String description, @JsonProperty("releaseInfo") @Nullable String releaseInfo, @JsonProperty("year") @Nullable String year, @JsonProperty("imdbRating") @Nullable String imdbRating, @JsonProperty("genres") @Nullable List<String> list2, @JsonProperty("logo") @Nullable String logo, @JsonProperty("poster") @Nullable String poster, @JsonProperty("background") @Nullable String background, @JsonProperty("status") @Nullable String status, @JsonProperty("videos") @Nullable List<KitsuVideo> list3, @JsonProperty("links") @Nullable List<KitsuLink> list4) {
            this.id = id;
            this.kitsuId = kitsuId;
            this.imdbId = imdbId;
            this.type = type;
            this.animeType = animeType;
            this.name = name;
            this.aliases = list;
            this.description = description;
            this.releaseInfo = releaseInfo;
            this.year = year;
            this.imdbRating = imdbRating;
            this.genres = list2;
            this.logo = logo;
            this.poster = poster;
            this.background = background;
            this.status = status;
            this.videos = list3;
            this.links = list4;
        }

        public /* synthetic */ KitsuMeta(String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, String str8, String str9, String str10, List list2, String str11, String str12, String str13, String str14, List list3, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : list, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : list2, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : str12, (i & 16384) != 0 ? null : str13, (i & 32768) != 0 ? null : str14, (i & 65536) != 0 ? null : list3, (i & 131072) == 0 ? list4 : null);
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getKitsuId() {
            return this.kitsuId;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getAnimeType() {
            return this.animeType;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final List<String> getAliases() {
            return this.aliases;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getReleaseInfo() {
            return this.releaseInfo;
        }

        @Nullable
        public final String getYear() {
            return this.year;
        }

        @Nullable
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final List<String> getGenres() {
            return this.genres;
        }

        @Nullable
        public final String getLogo() {
            return this.logo;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String getBackground() {
            return this.background;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final List<KitsuVideo> getVideos() {
            return this.videos;
        }

        @Nullable
        public final List<KitsuLink> getLinks() {
            return this.links;
        }

        @Nullable
        public final Integer getNumericKitsuId() {
            Integer intOrNull;
            String str = this.kitsuId;
            return (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? StringsKt.toIntOrNull(StringsKt.removePrefix(this.id, "kitsu:")) : intOrNull;
        }

        @Nullable
        public final Integer getYearInt() {
            String strTake;
            Integer intOrNull;
            String str = this.year;
            if (str != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
                return intOrNull;
            }
            String str2 = this.releaseInfo;
            if (str2 == null || (strTake = StringsKt.take(str2, 4)) == null) {
                return null;
            }
            return StringsKt.toIntOrNull(strTake);
        }

        @NotNull
        public final SearchResponse toSearchResponse(@NotNull MainAPI api) {
            TvType tvType;
            Float floatOrNull;
            String str = this.name;
            final Integer rating = null;
            if (str == null) {
                List<String> list = this.aliases;
                str = list != null ? (String) CollectionsKt.firstOrNull(list) : null;
                if (str == null) {
                    str = "";
                }
            }
            String title = str;
            String kId = this.kitsuId;
            if (kId == null) {
                kId = StringsKt.removePrefix(this.id, "kitsu:");
            }
            String url = "https://kitsu.io/anime/" + kId;
            String str2 = this.imdbRating;
            if (str2 != null && (floatOrNull = StringsKt.toFloatOrNull(str2)) != null) {
                float it = floatOrNull.floatValue();
                rating = Integer.valueOf((int) (10.0f * it));
            }
            if (StringsKt.equals(this.type, "movie", true) || StringsKt.equals(this.animeType, "movie", true)) {
                tvType = TvType.AnimeMovie;
            } else {
                tvType = TvType.Anime;
            }
            return MainAPIKt.newAnimeSearchResponse$default(api, title, url, tvType, false, new Function1() { // from class: com.phisher98.TorraStreamKitsuHelper$KitsuMeta$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return TorraStreamKitsuHelper.KitsuMeta.toSearchResponse$lambda$1(this.f$0, rating, (AnimeSearchResponse) obj);
                }
            }, 8, (Object) null);
        }

        static final Unit toSearchResponse$lambda$1(KitsuMeta this$0, Integer $rating, AnimeSearchResponse $this$newAnimeSearchResponse) {
            $this$newAnimeSearchResponse.setPosterUrl(this$0.poster);
            if ($rating != null) {
                $this$newAnimeSearchResponse.setScore(Score.Companion.from100($rating));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: TorraStreamKitsuHelper.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0002\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0092\u0002\u0010*\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010HÆ\u0001¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010/\u001a\u00020\tHÖ\u0081\u0004J\n\u00100\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001f\u0010\u0018Ê\u0001\f\b2\u0012\b\b3\u0012\u0004\b\u0007\u0010\u0002¨\u00061"}, d2 = {"Lcom/phisher98/TorraStreamKitsuHelper$KitsuVideo;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title", "released", "season", "", "episode", "thumbnail", "overview", "imdbId", "imdb_id", "imdbSeason", "imdbEpisode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getTitle", "getReleased", "getSeason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisode", "getThumbnail", "getOverview", "getImdbId", "getImdbSeason", "getImdbEpisode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/TorraStreamKitsuHelper$KitsuVideo;", "equals", "", "other", "hashCode", "toString", "TorraStream", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class KitsuVideo {

        @Nullable
        private final Integer episode;

        @Nullable
        private final String id;

        @Nullable
        private final Integer imdbEpisode;

        @Nullable
        private final String imdbId;

        @Nullable
        private final Integer imdbSeason;

        @Nullable
        private final String overview;

        @Nullable
        private final String released;

        @Nullable
        private final Integer season;

        @Nullable
        private final String thumbnail;

        @Nullable
        private final String title;

        public KitsuVideo() {
            this(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        public static /* synthetic */ KitsuVideo copy$default(KitsuVideo kitsuVideo, String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, String str6, Integer num3, Integer num4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = kitsuVideo.id;
            }
            if ((i & 2) != 0) {
                str2 = kitsuVideo.title;
            }
            if ((i & 4) != 0) {
                str3 = kitsuVideo.released;
            }
            if ((i & 8) != 0) {
                num = kitsuVideo.season;
            }
            if ((i & 16) != 0) {
                num2 = kitsuVideo.episode;
            }
            if ((i & 32) != 0) {
                str4 = kitsuVideo.thumbnail;
            }
            if ((i & 64) != 0) {
                str5 = kitsuVideo.overview;
            }
            if ((i & 128) != 0) {
                str6 = kitsuVideo.imdbId;
            }
            if ((i & 256) != 0) {
                num3 = kitsuVideo.imdbSeason;
            }
            if ((i & 512) != 0) {
                num4 = kitsuVideo.imdbEpisode;
            }
            Integer num5 = num3;
            Integer num6 = num4;
            String str7 = str5;
            String str8 = str6;
            Integer num7 = num2;
            String str9 = str4;
            return kitsuVideo.copy(str, str2, str3, num, num7, str9, str7, str8, num5, num6);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getImdbEpisode() {
            return this.imdbEpisode;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getReleased() {
            return this.released;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getImdbSeason() {
            return this.imdbSeason;
        }

        @NotNull
        public final KitsuVideo copy(@JsonProperty("id") @Nullable String id, @JsonProperty("title") @Nullable String title, @JsonProperty("released") @Nullable String released, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("thumbnail") @Nullable String thumbnail, @JsonProperty("overview") @Nullable String overview, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("imdbSeason") @Nullable Integer imdbSeason, @JsonProperty("imdbEpisode") @Nullable Integer imdbEpisode) {
            return new KitsuVideo(id, title, released, season, episode, thumbnail, overview, imdbId, imdbSeason, imdbEpisode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof KitsuVideo)) {
                return false;
            }
            KitsuVideo kitsuVideo = (KitsuVideo) other;
            return Intrinsics.areEqual(this.id, kitsuVideo.id) && Intrinsics.areEqual(this.title, kitsuVideo.title) && Intrinsics.areEqual(this.released, kitsuVideo.released) && Intrinsics.areEqual(this.season, kitsuVideo.season) && Intrinsics.areEqual(this.episode, kitsuVideo.episode) && Intrinsics.areEqual(this.thumbnail, kitsuVideo.thumbnail) && Intrinsics.areEqual(this.overview, kitsuVideo.overview) && Intrinsics.areEqual(this.imdbId, kitsuVideo.imdbId) && Intrinsics.areEqual(this.imdbSeason, kitsuVideo.imdbSeason) && Intrinsics.areEqual(this.imdbEpisode, kitsuVideo.imdbEpisode);
        }

        public int hashCode() {
            return ((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.released == null ? 0 : this.released.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.imdbSeason == null ? 0 : this.imdbSeason.hashCode())) * 31) + (this.imdbEpisode != null ? this.imdbEpisode.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "KitsuVideo(id=" + this.id + ", title=" + this.title + ", released=" + this.released + ", season=" + this.season + ", episode=" + this.episode + ", thumbnail=" + this.thumbnail + ", overview=" + this.overview + ", imdbId=" + this.imdbId + ", imdbSeason=" + this.imdbSeason + ", imdbEpisode=" + this.imdbEpisode + ')';
        }

        public KitsuVideo(@JsonProperty("id") @Nullable String id, @JsonProperty("title") @Nullable String title, @JsonProperty("released") @Nullable String released, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("thumbnail") @Nullable String thumbnail, @JsonProperty("overview") @Nullable String overview, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("imdbSeason") @Nullable Integer imdbSeason, @JsonProperty("imdbEpisode") @Nullable Integer imdbEpisode) {
            this.id = id;
            this.title = title;
            this.released = released;
            this.season = season;
            this.episode = episode;
            this.thumbnail = thumbnail;
            this.overview = overview;
            this.imdbId = imdbId;
            this.imdbSeason = imdbSeason;
            this.imdbEpisode = imdbEpisode;
        }

        public /* synthetic */ KitsuVideo(String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, String str6, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : num3, (i & 512) != 0 ? null : num4);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getReleased() {
            return this.released;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final Integer getImdbSeason() {
            return this.imdbSeason;
        }

        @Nullable
        public final Integer getImdbEpisode() {
            return this.imdbEpisode;
        }
    }

    /* JADX INFO: compiled from: TorraStreamKitsuHelper.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bÊ\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u0018"}, d2 = {"Lcom/phisher98/TorraStreamKitsuHelper$KitsuLink;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "category", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getCategory", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "TorraStream", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class KitsuLink {

        @Nullable
        private final String category;

        @Nullable
        private final String name;

        @Nullable
        private final String url;

        public KitsuLink() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ KitsuLink copy$default(KitsuLink kitsuLink, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = kitsuLink.name;
            }
            if ((i & 2) != 0) {
                str2 = kitsuLink.category;
            }
            if ((i & 4) != 0) {
                str3 = kitsuLink.url;
            }
            return kitsuLink.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final KitsuLink copy(@JsonProperty("name") @Nullable String name, @JsonProperty("category") @Nullable String category, @JsonProperty("url") @Nullable String url) {
            return new KitsuLink(name, category, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof KitsuLink)) {
                return false;
            }
            KitsuLink kitsuLink = (KitsuLink) other;
            return Intrinsics.areEqual(this.name, kitsuLink.name) && Intrinsics.areEqual(this.category, kitsuLink.category) && Intrinsics.areEqual(this.url, kitsuLink.url);
        }

        public int hashCode() {
            return ((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.category == null ? 0 : this.category.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "KitsuLink(name=" + this.name + ", category=" + this.category + ", url=" + this.url + ')';
        }

        public KitsuLink(@JsonProperty("name") @Nullable String name, @JsonProperty("category") @Nullable String category, @JsonProperty("url") @Nullable String url) {
            this.name = name;
            this.category = category;
            this.url = url;
        }

        public /* synthetic */ KitsuLink(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }
    }

    @NotNull
    public final String mapSectionToKitsuCatalog(@NotNull String sectionName) {
        if (StringsKt.contains(sectionName, "Trending", true)) {
            return "kitsu-anime-trending";
        }
        if (StringsKt.contains(sectionName, "Season", true) || StringsKt.contains(sectionName, "Airing", true)) {
            return "kitsu-anime-airing";
        }
        if (StringsKt.contains(sectionName, "Popular", true)) {
            return "kitsu-anime-popular";
        }
        return (StringsKt.contains(sectionName, "Top", true) || StringsKt.contains(sectionName, "Rating", true)) ? "kitsu-anime-rating" : "kitsu-anime-trending";
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public final Object getCatalog(@NotNull MainAPI api, @NotNull String catalogId, int page, @NotNull Continuation<? super Pair<? extends List<? extends SearchResponse>, Boolean>> continuation) {
        C00621 c00621;
        boolean z;
        int page2;
        MainAPI api2;
        Object obj;
        Object safe;
        if (continuation instanceof C00621) {
            c00621 = (C00621) continuation;
            if ((c00621.label & Integer.MIN_VALUE) != 0) {
                c00621.label -= Integer.MIN_VALUE;
            } else {
                c00621 = new C00621(continuation);
            }
        } else {
            c00621 = new C00621(continuation);
        }
        Object $result = c00621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00621.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int skip = (page - 1) * 50;
                String url = skip > 0 ? "https://anime-kitsu.strem.fun/catalog/anime/" + catalogId + "/skip=" + skip + ".json" : "https://anime-kitsu.strem.fun/catalog/anime/" + catalogId + ".json";
                Requests app = MainActivityKt.getApp();
                c00621.L$0 = api;
                c00621.L$1 = SpillingKt.nullOutSpilledVariable(catalogId);
                c00621.L$2 = SpillingKt.nullOutSpilledVariable(url);
                c00621.I$0 = page;
                c00621.I$1 = skip;
                c00621.label = 1;
                z = true;
                page2 = 50;
                Object obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00621, 4094, (Object) null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                api2 = api;
                obj = obj2;
                break;
                break;
            case 1:
                int i = c00621.I$1;
                int i2 = c00621.I$0;
                api2 = (MainAPI) c00621.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                obj = $result;
                page2 = 50;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) obj;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(KitsuCatalogResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        KitsuCatalogResponse res = (KitsuCatalogResponse) safe;
        if (res == null) {
            return TuplesKt.to(CollectionsKt.emptyList(), Boxing.boxBoolean(false));
        }
        Iterable $this$map$iv = res.getMetas();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KitsuMeta it = (KitsuMeta) item$iv$iv;
            destination$iv$iv.add(it.toSearchResponse(api2));
        }
        List list = (List) destination$iv$iv;
        boolean hasNextPage = list.size() >= page2;
        if (!hasNextPage) {
            z = false;
        }
        return TuplesKt.to(list, Boxing.boxBoolean(z));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object search(@NotNull MainAPI api, @NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws UnsupportedEncodingException {
        C00641 c00641;
        Object obj;
        MainAPI api2;
        Object safe;
        if (continuation instanceof C00641) {
            c00641 = (C00641) continuation;
            if ((c00641.label & Integer.MIN_VALUE) != 0) {
                c00641.label -= Integer.MIN_VALUE;
            } else {
                c00641 = new C00641(continuation);
            }
        } else {
            c00641 = new C00641(continuation);
        }
        C00641 c00642 = c00641;
        Object $result = c00642.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00642.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String encoded = URLEncoder.encode(query, StandardCharsets.UTF_8.name());
                String url = "https://anime-kitsu.strem.fun/catalog/anime/kitsu-anime-list/search=" + encoded + ".json";
                Requests app = MainActivityKt.getApp();
                c00642.L$0 = api;
                c00642.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00642.L$2 = SpillingKt.nullOutSpilledVariable(encoded);
                c00642.L$3 = SpillingKt.nullOutSpilledVariable(url);
                c00642.label = 1;
                obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00642, 4094, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                api2 = api;
                break;
                break;
            case 1:
                api2 = (MainAPI) c00642.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) obj;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(KitsuCatalogResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        KitsuCatalogResponse res = (KitsuCatalogResponse) safe;
        if (res == null) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = res.getMetas();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KitsuMeta it = (KitsuMeta) item$iv$iv;
            destination$iv$iv.add(it.toSearchResponse(api2));
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public final Object getMeta(@NotNull String idWithPrefix, @NotNull Continuation<? super KitsuMeta> continuation) {
        C00631 c00631;
        String formattedId;
        Object obj;
        Object safe;
        if (continuation instanceof C00631) {
            c00631 = (C00631) continuation;
            if ((c00631.label & Integer.MIN_VALUE) != 0) {
                c00631.label -= Integer.MIN_VALUE;
            } else {
                c00631 = new C00631(continuation);
            }
        } else {
            c00631 = new C00631(continuation);
        }
        Object $result = c00631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00631.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.startsWith$default(idWithPrefix, "kitsu:", false, 2, (Object) null) || StringsKt.startsWith$default(idWithPrefix, "anilist:", false, 2, (Object) null) || StringsKt.startsWith$default(idWithPrefix, "mal:", false, 2, (Object) null) || StringsKt.startsWith$default(idWithPrefix, "anidb:", false, 2, (Object) null) || StringsKt.toIntOrNull(idWithPrefix) == null) {
                    formattedId = idWithPrefix;
                } else {
                    formattedId = "kitsu:" + idWithPrefix;
                }
                String url = "https://anime-kitsu.strem.fun/meta/anime/" + formattedId + ".json";
                Requests app = MainActivityKt.getApp();
                c00631.L$0 = SpillingKt.nullOutSpilledVariable(idWithPrefix);
                c00631.L$1 = SpillingKt.nullOutSpilledVariable(formattedId);
                c00631.L$2 = SpillingKt.nullOutSpilledVariable(url);
                c00631.label = 1;
                obj = null;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00631, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = null;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(KitsuMetaResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = obj;
        }
        KitsuMetaResponse kitsuMetaResponse = (KitsuMetaResponse) safe;
        return kitsuMetaResponse != null ? kitsuMetaResponse.getMeta() : obj;
    }
}
