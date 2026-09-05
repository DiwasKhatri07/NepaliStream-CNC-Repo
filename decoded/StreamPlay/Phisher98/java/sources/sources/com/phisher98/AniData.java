package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012*\b\u0003\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003JO\u0010\u0016\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022*\b\u0003\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/phisher98/AniData;", "", "Page", "Lcom/phisher98/AniPage;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "media", "Ljava/util/ArrayList;", "Lcom/phisher98/AniMedia;", "Lkotlin/collections/ArrayList;", "<init>", "(Lcom/phisher98/AniPage;Ljava/util/ArrayList;)V", "getPage", "()Lcom/phisher98/AniPage;", "setPage", "(Lcom/phisher98/AniPage;)V", "getMedia", "()Ljava/util/ArrayList;", "setMedia", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AniData {

    @Nullable
    private AniPage Page;

    @Nullable
    private ArrayList<AniMedia> media;

    /* JADX WARN: Multi-variable type inference failed */
    public AniData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AniData copy$default(AniData aniData, AniPage aniPage, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            aniPage = aniData.Page;
        }
        if ((i & 2) != 0) {
            arrayList = aniData.media;
        }
        return aniData.copy(aniPage, arrayList);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AniPage getPage() {
        return this.Page;
    }

    @Nullable
    public final ArrayList<AniMedia> component2() {
        return this.media;
    }

    @NotNull
    public final AniData copy(@JsonProperty("Page") @Nullable AniPage Page, @JsonProperty("media") @Nullable ArrayList<AniMedia> media) {
        return new AniData(Page, media);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AniData)) {
            return false;
        }
        AniData aniData = (AniData) other;
        return Intrinsics.areEqual(this.Page, aniData.Page) && Intrinsics.areEqual(this.media, aniData.media);
    }

    public int hashCode() {
        return ((this.Page == null ? 0 : this.Page.hashCode()) * 31) + (this.media != null ? this.media.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AniData(Page=" + this.Page + ", media=" + this.media + ')';
    }

    public AniData(@JsonProperty("Page") @Nullable AniPage Page, @JsonProperty("media") @Nullable ArrayList<AniMedia> arrayList) {
        this.Page = Page;
        this.media = arrayList;
    }

    public /* synthetic */ AniData(AniPage aniPage, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : aniPage, (i & 2) != 0 ? null : arrayList);
    }

    @Nullable
    public final AniPage getPage() {
        return this.Page;
    }

    public final void setPage(@Nullable AniPage aniPage) {
        this.Page = aniPage;
    }

    @Nullable
    public final ArrayList<AniMedia> getMedia() {
        return this.media;
    }

    public final void setMedia(@Nullable ArrayList<AniMedia> arrayList) {
        this.media = arrayList;
    }
}
