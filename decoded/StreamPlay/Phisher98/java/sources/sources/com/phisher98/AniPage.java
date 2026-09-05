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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012&\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002&\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/AniPage;", "", "media", "Ljava/util/ArrayList;", "Lcom/phisher98/AniMedia;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getMedia", "()Ljava/util/ArrayList;", "setMedia", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AniPage {

    @NotNull
    private ArrayList<AniMedia> media;

    /* JADX WARN: Illegal instructions before constructor call */
    public AniPage() {
        ArrayList arrayList = null;
        this(arrayList, 1, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AniPage copy$default(AniPage aniPage, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = aniPage.media;
        }
        return aniPage.copy(arrayList);
    }

    @NotNull
    public final ArrayList<AniMedia> component1() {
        return this.media;
    }

    @NotNull
    public final AniPage copy(@JsonProperty("media") @NotNull ArrayList<AniMedia> media) {
        return new AniPage(media);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AniPage) && Intrinsics.areEqual(this.media, ((AniPage) other).media);
    }

    public int hashCode() {
        return this.media.hashCode();
    }

    @NotNull
    public String toString() {
        return "AniPage(media=" + this.media + ')';
    }

    public AniPage(@JsonProperty("media") @NotNull ArrayList<AniMedia> arrayList) {
        this.media = arrayList;
    }

    public /* synthetic */ AniPage(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    @NotNull
    public final ArrayList<AniMedia> getMedia() {
        return this.media;
    }

    public final void setMedia(@NotNull ArrayList<AniMedia> arrayList) {
        this.media = arrayList;
    }
}
