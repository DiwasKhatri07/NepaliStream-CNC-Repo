package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Jellyfin/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\f\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/phisher98/ImageTags;", "", "primary", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Primary", "<init>", "(Ljava/lang/String;)V", "getPrimary", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ImageTags {

    @Nullable
    private final String primary;

    public static /* synthetic */ ImageTags copy$default(ImageTags imageTags, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageTags.primary;
        }
        return imageTags.copy(str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPrimary() {
        return this.primary;
    }

    @NotNull
    public final ImageTags copy(@JsonProperty("Primary") @Nullable String primary) {
        return new ImageTags(primary);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ImageTags) && Intrinsics.areEqual(this.primary, ((ImageTags) other).primary);
    }

    public int hashCode() {
        if (this.primary == null) {
            return 0;
        }
        return this.primary.hashCode();
    }

    @NotNull
    public String toString() {
        return "ImageTags(primary=" + this.primary + ')';
    }

    public ImageTags(@JsonProperty("Primary") @Nullable String primary) {
        this.primary = primary;
    }

    @Nullable
    public final String getPrimary() {
        return this.primary;
    }
}
